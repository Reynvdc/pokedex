package be.reynvdc.pokedex.core.database.pokemon.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_pokemon")
data class FavoritePokemon(
    @PrimaryKey var pokemonId : Int
)
