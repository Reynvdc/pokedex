package be.reynvdc.pokedex.core.database.pokemon.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule

@Entity(tableName = "pokemon")
@TypeConverters(JsonConverter::class)
data class Pokemon(
    @PrimaryKey var id: Int,
    var name: String,
    @Embedded var sprites: Sprites,
    var abilities: List<Ability> = listOf(),
    var moves: List<Move> = listOf(),
    var types: List<Type> = listOf(),
    var height: Float? = null,
    var weight: Float? = null,
    @Embedded var stats: Stats? = null
){
    fun hasDetails(): Boolean {
        return moves.isNotEmpty() && abilities.isNotEmpty()
    }
}

class JsonConverter {
    @TypeConverter
    fun fromTypes(value: List<Type>): String {
        return objectMapper.writeValueAsString(value)
    }
    @TypeConverter
    fun toTypes(value: String): List<Type> {
        return objectMapper.readValue(value, object : TypeReference<List<Type>>() {})
    }

    @TypeConverter
    fun fromMoves(value: List<Move>): String {
        return objectMapper.writeValueAsString(value)
    }
    @TypeConverter
    fun toMoves(value: String): List<Move> {
        return objectMapper.readValue(value, object : TypeReference<List<Move>>() {})
    }

    @TypeConverter
    fun fromAbilities(value: List<Ability>): String {
        return objectMapper.writeValueAsString(value)
    }
    @TypeConverter
    fun toAbilities(value: String): List<Ability> {
        return objectMapper.readValue(value, object : TypeReference<List<Ability>>() {})
    }

    companion object{
        var objectMapper = ObjectMapper().registerModule(KotlinModule.Builder().build())
    }
}
