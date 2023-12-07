package be.reynvdc.pokedex.core.service

import be.reynvdc.pokedex.core.database.pokemon.PokemonDatabase
import be.reynvdc.pokedex.core.database.pokemon.entities.FavoritePokemon
import be.reynvdc.pokedex.core.database.pokemon.mapper.PokemonServiceMapper
import be.reynvdc.pokedex.core.service.model.Pokemon

class FavoritePokemonServiceImpl : FavoritePokemonService {
    override suspend fun getFavoritePokemonList(): List<Pokemon> {
        val pokemonList = PokemonDatabase.INSTANCE?.favoritePokemonDao()?.getAllFavoritePokemon() ?: listOf()
        return PokemonServiceMapper.toPokemonList(pokemonList)
    }

    override suspend fun isFavorite(pokemon: Pokemon): Boolean {
       return PokemonDatabase.INSTANCE?.favoritePokemonDao()?.exists(pokemon.id) ?: false
    }

    override suspend fun getTotal(): Int {
        return PokemonDatabase.INSTANCE?.favoritePokemonDao()?.count() ?: 0
    }

    override suspend fun add(pokemon: Pokemon) {
        PokemonDatabase.INSTANCE?.favoritePokemonDao()?.insert(FavoritePokemon(pokemon.id))
    }

    override suspend fun delete(pokemon: Pokemon) {
        PokemonDatabase.INSTANCE?.favoritePokemonDao()?.delete(FavoritePokemon(pokemon.id))
    }
}