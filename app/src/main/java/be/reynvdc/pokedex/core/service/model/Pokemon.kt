package be.reynvdc.pokedex.core.service.model


data class Pokemon(
    val id: Int,
    val name: String,
    val sprites: Sprites,
    val types: List<Type>,
    val height: Float? = null,
    val weight: Float?= null,
    val abilities: List<Ability> = listOf(),
    val moves: List<Move> = listOf(),
    val stats: Stats? = null
)
