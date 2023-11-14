package be.reynvdc.pokedex.core.client.appwise.model

data class AppwisePokemon(
    var id: String,
    var name: String,
    var sprites: Sprite,
    var types: List<Type>
)