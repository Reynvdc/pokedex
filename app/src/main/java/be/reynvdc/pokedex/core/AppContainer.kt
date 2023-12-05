package be.reynvdc.pokedex.core;

import be.reynvdc.pokedex.core.service.FavoritePokemonService
import be.reynvdc.pokedex.core.service.FavoritePokemonServiceImpl
import be.reynvdc.pokedex.core.service.PokemonService
import be.reynvdc.pokedex.core.service.PokemonServiceImpl
import be.reynvdc.pokedex.mock.service.MockPokemonServiceImpl

interface AppContainer{
    val pokemonService : PokemonService
    val favoritePokemonService: FavoritePokemonService
}
class DefaultAppContainer : AppContainer {
    override val pokemonService: PokemonService by lazy {
        PokemonServiceImpl()
    }

    override val favoritePokemonService: FavoritePokemonService by lazy {
        FavoritePokemonServiceImpl()
    }
}

class MockAppContainer : AppContainer{
    override val pokemonService: PokemonService by lazy {
        MockPokemonServiceImpl()
    }

    override val favoritePokemonService: FavoritePokemonService
        get() = TODO("Not yet implemented")

}
