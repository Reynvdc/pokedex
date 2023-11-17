package be.reynvdc.pokedex.core.client.pokeapi.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Move(
    val name: String
)

data class MoveWrapper(
    val move: Move,
    @JsonProperty("version_group_details") val versionGroupDetails: List<VersionGroupDetail>
)