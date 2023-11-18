package be.reynvdc.pokedex.core.service.model

import be.reynvdc.pokedex.core.service.util.med

data class Stats(
    val hp: Int,
    val attack: Int,
    val defence: Int,
    val specialAttack: Int,
    val specialDefence: Int,
    val speed: Int,
){
    val median = listOf(hp, attack , defence , specialAttack , specialDefence , speed).med()

    companion object{
        private const val TOTAL_NUMBER_STATS:Int = 6
    }
}