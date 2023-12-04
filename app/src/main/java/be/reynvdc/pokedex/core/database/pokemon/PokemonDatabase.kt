package be.reynvdc.pokedex.core.database.pokemon

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import be.reynvdc.pokedex.core.database.pokemon.entities.Pokemon

@Database(entities = [Pokemon::class], version = 3)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao() : PokemonDao

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