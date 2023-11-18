package be.reynvdc.pokedex.core.client.pokeapi.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Move(
    @JsonProperty("move") val move: NameUrlProperty,
    @JsonProperty("version_group_details") val versionGroupDetails: List<VersionGroupDetail>
)