package be.reynvdc.pokedex.core.database.pokemon

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import be.reynvdc.pokedex.core.database.pokemon.entities.FavoritePokemon
import be.reynvdc.pokedex.core.database.pokemon.entities.Pokemon

@Database(entities = [Pokemon::class, FavoritePokemon::class], version = 6)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao() : PokemonDao
    abstract fun favoritePokemonDao(): FavoritePokemonDao

    companion object {

        @Volatile var INSTANCE: PokemonDatabase? = null

        fun getInstance(context: Context): PokemonDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                PokemonDatabase::class.java, "Pokemon.db").fallbackToDestructiveMigration()
                .build()
    }

}