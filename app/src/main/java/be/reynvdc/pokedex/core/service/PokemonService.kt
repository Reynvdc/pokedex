package be.reynvdc.pokedex.core.service

import be.reynvdc.pokedex.core.client.appwise.AppwisePokemonClient
import be.reynvdc.pokedex.core.client.appwise.model.AppwisePokemon
import be.reynvdc.pokedex.core.service.mapper.PokemonMapper
import be.reynvdc.pokedex.core.service.model.Pokemon

class PokemonService{


    private val client = AppwisePokemonClient.create()

    suspend fun getList() : List<Pokemon>{
        var appwisePokemonList = client.listPokemon()
        return PokemonMapper.toPokemonList(appwisePokemonList)
    }
}