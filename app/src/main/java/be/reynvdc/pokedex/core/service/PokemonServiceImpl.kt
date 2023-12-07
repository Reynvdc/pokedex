package be.reynvdc.pokedex.core.service

import be.reynvdc.pokedex.core.client.appwise.AppwisePokemonClient
import be.reynvdc.pokedex.core.client.pokeapi.PokeApiClient
import be.reynvdc.pokedex.core.client.pokeapi.model.PokeApiPokemon
import be.reynvdc.pokedex.core.database.pokemon.PokemonDatabase
import be.reynvdc.pokedex.core.database.pokemon.mapper.PokemonDatabaseMapper
import be.reynvdc.pokedex.core.database.pokemon.mapper.PokemonServiceMapper
import be.reynvdc.pokedex.core.service.exception.PokemonNotFoundException
import be.reynvdc.pokedex.core.service.mapper.PokemonMapper
import be.reynvdc.pokedex.core.service.model.Pokemon
import retrofit2.awaitResponse

class PokemonServiceImpl : PokemonService{

    private val appwisePokemonClient = AppwisePokemonClient.create()
    private val pokeApiPokemonClient = PokeApiClient.create()

    override suspend fun getList() : List<Pokemon>{
        val pokemonDatabaseList = PokemonDatabase.INSTANCE?.pokemonDao()?.loadAll() ?: listOf()
        return if(pokemonDatabaseList.isNotEmpty()){
            PokemonServiceMapper.toPokemonList(pokemonDatabaseList)
        } else{
            val appwisePokemonList = appwisePokemonClient.listPokemon()
            val pokemonList = PokemonMapper.toPokemonList(appwisePokemonList)
            PokemonDatabase.INSTANCE?.pokemonDao()?.insertAll(
                *PokemonDatabaseMapper.toPokemonList(pokemonList).toTypedArray()
            )
            pokemonList
        }
    }

    override suspend fun getPokemonById(id: Int): Pokemon {
        val pokemonDatabase = PokemonDatabase.INSTANCE?.pokemonDao()?.findById(id)
        return if (pokemonDatabase != null && pokemonDatabase.hasDetails()) {
            val pokemon = PokemonServiceMapper.toPokemon(pokemonDatabase)
            pokemon
        }
        else {
            val pokemon = getPokemonByString(id.toString())
            PokemonDatabase.INSTANCE?.pokemonDao()?.insert(
                PokemonDatabaseMapper.toPokemon(pokemon)
            )
            pokemon
        }
    }

    override suspend fun getPokemonByString(value: String): Pokemon {
        val callGetPokemon = pokeApiPokemonClient.getPokemonByIdOrString(value.lowercase())
        val response = callGetPokemon.awaitResponse()
        if(response.isSuccessful) {
            val pokeApiPokemon: PokeApiPokemon = response.body()
            ?: throw PokemonNotFoundException("Pokemon not found with name or id=$value")
            return PokemonMapper.toPokemon(pokeApiPokemon)
        }
        else throw PokemonNotFoundException("Pokemon not found with name or id=$value")
    }
}