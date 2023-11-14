package be.reynvdc.pokedex.core.service

import be.reynvdc.pokedex.core.service.model.Pokemon

interface PokemonService {
    suspend fun getList() : List<Pokemon>
}