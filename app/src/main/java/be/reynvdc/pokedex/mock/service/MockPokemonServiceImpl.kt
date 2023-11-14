package be.reynvdc.pokedex.mock.service

import be.reynvdc.pokedex.core.service.PokemonService
import be.reynvdc.pokedex.core.service.model.Pokemon
import be.reynvdc.pokedex.core.service.model.Sprite
import be.reynvdc.pokedex.core.service.model.Type

class MockPokemonServiceImpl : PokemonService {
    override suspend fun getList(): List<Pokemon> {
        return listOf(
            Pokemon(
                id= "1",
                name = "bulbasaur",
                sprites = Sprite(front_default = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"),
                types = listOf(Type(1, Type.TypeName("grass")))
            ),
            Pokemon(
                id= "4",
                name = "charmander",
                sprites = Sprite(front_default = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png"),
                types = listOf(Type(1,Type.TypeName("fire")))
            ),
            Pokemon(
                id= "7",
                name = "squirtle",
                sprites = Sprite(front_default = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png"),
                types = listOf(Type(1,Type.TypeName("water")))
            )
        )
    }
}