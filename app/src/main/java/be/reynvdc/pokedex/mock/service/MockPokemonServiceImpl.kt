package be.reynvdc.pokedex.mock.service

import be.reynvdc.pokedex.core.service.PokemonService
import be.reynvdc.pokedex.core.service.model.Pokemon
import be.reynvdc.pokedex.core.service.model.Sprites
import be.reynvdc.pokedex.core.service.model.Type

class MockPokemonServiceImpl : PokemonService {
    override suspend fun getList(): List<Pokemon> {
        return listOf(
            Pokemon(
                id= 4,
                name = "bulbasaur",
                sprites = Sprites(front_default = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"),
                types = listOf(Type(1, Type.TypeName("grass")))
            ),
            Pokemon(
                id= 4,
                name = "charmander",
                sprites = Sprites(front_default = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png"),
                types = listOf(Type(1,Type.TypeName("fire")))
            ),
            Pokemon(
                id= 7,
                name = "squirtle",
                sprites = Sprites(front_default = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png"),
                types = listOf(Type(1,Type.TypeName("water")))
            )
        )
    }

    override suspend fun getPokemonById(id: Int): Pokemon {
        return Pokemon(
            id= 7,
            name = "squirtle",
            sprites = Sprites(front_default = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png"),
            types = listOf(Type(1,Type.TypeName("water")))
        );
    }

    override suspend fun getPokemonByString(value: String): Pokemon {
        return getPokemonById(0)
    }


}