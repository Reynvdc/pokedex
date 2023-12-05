package be.reynvdc.pokedex.core.service

import android.util.Log
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
    private val favoritePokemonService = FavoritePokemonServiceImpl()

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
            testFavorite(pokemon)
            pokemon
        }
        else {
            val pokemon = getPokemonByString(id.toString())
            PokemonDatabase.INSTANCE?.pokemonDao()?.insert(
                PokemonDatabaseMapper.toPokemon(pokemon)
            )
            testFavorite(pokemon)
            pokemon
        }
    }

    private suspend fun testFavorite(pokemon:Pokemon){
        favoritePokemonService.add(pokemon)
        Log.d("favorite", "added pokemon")
        val favPokemon = favoritePokemonService.getFavoritePokemonList()
        val size = favoritePokemonService.getTotal()
        Log.d("favorite", "fav pokemonlist: $favPokemon")
        Log.d("favorite", "fav size: $size")
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