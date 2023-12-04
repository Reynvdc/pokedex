package be.reynvdc.pokedex.core.database.pokemon.entities


data class Stats(
    var hp: Int,
    var attack: Int,
    var defence: Int,
    var specialAttack: Int,
    var specialDefence: Int,
    var speed: Int,
)