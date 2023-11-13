package be.reynvdc.pokedex.core.client.appwise.model

data class Pokemon(
    var id: String,
    var name: String,
    var sprites: Sprite,
    var types: List<Type>
)
