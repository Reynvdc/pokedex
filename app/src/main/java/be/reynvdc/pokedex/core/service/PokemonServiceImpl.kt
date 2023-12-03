package be.reynvdc.pokedex.core.service

import be.reynvdc.pokedex.core.client.appwise.AppwisePokemonClient
import be.reynvdc.pokedex.core.client.pokeapi.PokeApiClient
import be.reynvdc.pokedex.core.client.pokeapi.model.PokeApiPokemon
import be.reynvdc.pokedex.core.service.exception.PokemonNotFoundException
import be.reynvdc.pokedex.core.service.mapper.PokemonMapper
import be.reynvdc.pokedex.core.service.model.Pokemon
import retrofit2.awaitResponse

class PokemonServiceImpl : PokemonService{

    private val appwisePokemonClient = AppwisePokemonClient.create()
    private val pokeApiPokemonClient = PokeApiClient.create()

    override suspend fun getList() : List<Pokemon>{
        val appwisePokemonList = appwisePokemonClient.listPokemon()
        return PokemonMapper.toPokemonList(appwisePokemonList)
    }

    override suspend fun getPokemonById(id: Int): Pokemon {
        return getPokemonByString(id.toString())
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