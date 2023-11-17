package be.reynvdc.pokedex.core.client.pokeapi.model

import be.reynvdc.pokedex.core.client.appwise.model.Type

data class PokeApiPokemon (
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val sprites: Sprites,
    val abilities: List<AbilityWrapper>,
    val moves: List<MoveWrapper>,
    val types: List<Type>

)
