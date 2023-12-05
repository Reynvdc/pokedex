package be.reynvdc.pokedex.core.database.pokemon

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import be.reynvdc.pokedex.core.database.pokemon.entities.Pokemon

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon")
    suspend fun loadAll(): List<Pokemon>

    @Query("SELECT * FROM pokemon WHERE id= :id")
    suspend fun findById(id:Int): Pokemon

    @Query("SELECT * FROM pokemon WHERE id IN (:pokemonIds)")
    suspend fun loadAllBySongId(vararg pokemonIds: Int): List<Pokemon>

    @Upsert
    suspend fun insertAll(vararg pokemons: Pokemon)
    @Upsert
    suspend fun insert(pokemon: Pokemon)
}