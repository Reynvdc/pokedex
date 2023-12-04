package be.reynvdc.pokedex

import android.app.Application
import be.reynvdc.pokedex.core.AppContainer
import be.reynvdc.pokedex.core.DefaultAppContainer
import be.reynvdc.pokedex.core.database.pokemon.PokemonDatabase

class PokedexApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        PokemonDatabase.getInstance(this)
        container = DefaultAppContainer()
    }
}