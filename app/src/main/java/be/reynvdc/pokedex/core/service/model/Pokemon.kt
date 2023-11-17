package be.reynvdc.pokedex.core.service.model


data class Pokemon(
    val id: Int,
    val name: String,
    val sprites: Sprites,
    val types: List<Type>,
    val height: Int? = null,
    val weight: Int?= null,
    val abilities: List<Ability> = listOf(),
    val moves: List<Move> = listOf(),
)
