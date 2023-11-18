package be.reynvdc.pokedex.core.client.pokeapi.model

import be.reynvdc.pokedex.core.client.appwise.model.Type

data class PokeApiPokemon (
    val id: Int,
    val name: String,
    val height: Float,
    val weight: Float,
    val sprites: Sprites,
    val abilities: List<Ability>,
    val moves: List<Move>,
    val types: List<Type>,
    val stats: List<Stat>

)
