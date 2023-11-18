package be.reynvdc.pokedex.core.client.pokeapi.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Stat(
    @JsonProperty("base_stat") val baseStat: Int,
    val stat: NameUrlProperty
)

enum class StatName(val label: String) {
    HP("hp"),
    ATTACK("attack"),
    DEFENCE("defense"),
    SPECIAL_ATTACK("special-attack"),
    SPECIAL_DEFENCE("special-defense"),
    SPEED("speed"),
}


