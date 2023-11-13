package be.reynvdc.pokedex.core.client.appwise.model

data class Type(
    var slot: Int,
    var type: TypeName
) {
    data class TypeName(
        var name: String
    )
}
