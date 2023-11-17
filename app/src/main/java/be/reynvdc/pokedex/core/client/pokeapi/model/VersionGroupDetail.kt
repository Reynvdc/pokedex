package be.reynvdc.pokedex.core.client.pokeapi.model

import com.fasterxml.jackson.annotation.JsonProperty

data class VersionGroupDetail(
    @JsonProperty("level_learned_at") val levelLearnedAt: Int,
)
