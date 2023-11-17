package be.reynvdc.pokedex.core.client.appwise.model

data class AppwisePokemon(
    val id: Int,
    val name: String,
    val sprites: Sprites,
    val types: List<Type>
)
