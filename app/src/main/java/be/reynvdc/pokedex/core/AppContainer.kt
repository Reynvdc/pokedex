package be.reynvdc.pokedex.core;

import be.reynvdc.pokedex.core.service.PokemonService
import be.reynvdc.pokedex.core.service.PokemonServiceImpl
import be.reynvdc.pokedex.mock.service.MockPokemonServiceImpl

interface AppContainer{
    val pokemonService : PokemonService
}
class DefaultAppContainer : AppContainer {
    override val pokemonService: PokemonService by lazy {
        PokemonServiceImpl()
    }
}

class MockAppContainer : AppContainer{
    override val pokemonService: PokemonService by lazy {
        MockPokemonServiceImpl()
    }

}
