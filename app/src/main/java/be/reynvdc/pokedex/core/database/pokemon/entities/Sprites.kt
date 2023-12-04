package be.reynvdc.pokedex.core.database.pokemon.entities

import androidx.room.Entity

@Entity(tableName = "sprites")
data class Sprites (
    var front_default: String
)
