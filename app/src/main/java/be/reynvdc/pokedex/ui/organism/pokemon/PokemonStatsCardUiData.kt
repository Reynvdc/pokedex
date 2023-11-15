package be.reynvdc.pokedex.ui.organism.pokemon

import be.reynvdc.pokedex.ui.atom.property.StatPropertyUiData

data class PokemonStatsCardUiData (
    val title: String,
    val hp: StatPropertyUiData,
    val attack: StatPropertyUiData,
    val defence: StatPropertyUiData,
    val specialAttack: StatPropertyUiData,
    val specialDefence: StatPropertyUiData,
    val speed: StatPropertyUiData,
    val total: StatPropertyUiData,
)
