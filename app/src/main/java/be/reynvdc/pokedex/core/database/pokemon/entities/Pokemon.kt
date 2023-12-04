package be.reynvdc.pokedex.core.database.pokemon.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
@Entity(tableName = "pokemon")
data class Pokemon(
    @PrimaryKey var id: Int,
    var name: String,
    @Embedded var sprites: Sprites,
    var height: Float? = null,
    var weight: Float? = null,
    @Embedded var stats: Stats? = null
){
    @Ignore var types: List<Type> = listOf()
    @Ignore var abilities: List<Ability> = listOf()
    @Ignore var moves: List<Move> = listOf()

}
