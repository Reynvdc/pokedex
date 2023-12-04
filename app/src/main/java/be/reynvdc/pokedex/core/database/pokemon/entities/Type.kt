package be.reynvdc.pokedex.core.database.pokemon.entities

data class Type(
    var slot: Int,
    var type: TypeName
) {
    data class TypeName(
        var name: String
    )
}
