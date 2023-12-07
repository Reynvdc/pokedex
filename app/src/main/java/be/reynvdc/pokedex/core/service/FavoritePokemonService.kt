package be.reynvdc.pokedex.core.service

import be.reynvdc.pokedex.core.service.model.Pokemon

interface FavoritePokemonService {

    suspend fun getFavoritePokemonList() : List<Pokemon>

    suspend fun isFavorite(pokemon: Pokemon): Boolean

    suspend fun getTotal():Int
    suspend fun add(pokemon: Pokemon)
    suspend fun delete(pokemon: Pokemon)
}