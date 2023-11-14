package be.reynvdc.pokedex.core.service

import be.reynvdc.pokedex.core.client.appwise.AppwisePokemonClient
import be.reynvdc.pokedex.core.service.mapper.PokemonMapper
import be.reynvdc.pokedex.core.service.model.Pokemon

class PokemonServiceImpl : PokemonService{

    private val client = AppwisePokemonClient.create()

    override suspend fun getList() : List<Pokemon>{
        var appwisePokemonList = client.listPokemon()
        return PokemonMapper.toPokemonList(appwisePokemonList)
    }
}