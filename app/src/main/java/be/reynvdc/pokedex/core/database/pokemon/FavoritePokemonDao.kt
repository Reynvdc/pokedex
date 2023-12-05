package be.reynvdc.pokedex.core.database.pokemon

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import be.reynvdc.pokedex.core.database.pokemon.entities.FavoritePokemon
import be.reynvdc.pokedex.core.database.pokemon.entities.Pokemon

@Dao
interface FavoritePokemonDao {
    @Delete
    suspend fun delete(favoritePokemon: FavoritePokemon)
    @Upsert
    suspend fun insert(favoritePokemon: FavoritePokemon)
    @Query("SELECT COUNT(pokemonId) FROM favorite_pokemon")
    suspend fun count(): Int
    @Query("SELECT pokemon.* FROM pokemon INNER JOIN favorite_pokemon ON pokemon.id = favorite_pokemon.pokemonId")
    suspend fun getAllFavoritePokemon(): List<Pokemon>
}