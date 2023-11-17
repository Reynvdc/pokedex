package be.reynvdc.pokedex.core.service

import be.reynvdc.pokedex.core.client.appwise.AppwisePokemonClient
import be.reynvdc.pokedex.core.client.pokeapi.PokeApiClient
import be.reynvdc.pokedex.core.client.pokeapi.model.PokeApiPokemon
import be.reynvdc.pokedex.core.service.exception.PokemonNotFoundException
import be.reynvdc.pokedex.core.service.mapper.PokemonMapper
import be.reynvdc.pokedex.core.service.model.Pokemon

class PokemonServiceImpl : PokemonService{

    private val appwisePokemonClient = AppwisePokemonClient.create()
    private val pokeApiPokemonClient = PokeApiClient.create()

    override suspend fun getList() : List<Pokemon>{
        var appwisePokemonList = appwisePokemonClient.listPokemon()
        return PokemonMapper.toPokemonList(appwisePokemonList)
    }

    override suspend fun getPokemonById(id: Int): Pokemon {
        var pokeApiPokemon: PokeApiPokemon =
            pokeApiPokemonClient.getPokemonById(id.toString()).execute().body()
                ?: throw PokemonNotFoundException("Pokemon not found with id=$id")
        return PokemonMapper.toPokemon(pokeApiPokemon)
    }
}