package be.reynvdc.pokedex.core.service.mapper

import be.reynvdc.pokedex.core.client.appwise.model.AppwisePokemon
import be.reynvdc.pokedex.core.service.model.Pokemon
import be.reynvdc.pokedex.core.service.model.Sprite
import be.reynvdc.pokedex.core.service.model.Type

class PokemonMapper {
    companion object{

        fun toPokemonList(appwisePokemonList: List<AppwisePokemon>): List<Pokemon>{
            return  appwisePokemonList.map { toPokemon(it) }
        }
        fun toPokemon(appwisePokemon: AppwisePokemon) : Pokemon {
            return Pokemon(
                id = appwisePokemon.id,
                name = appwisePokemon.name,
                sprites = toSprites(appwisePokemon.sprites),
                types = toTypeList(appwisePokemon.types)
            )
        }

        private fun toTypeList (types: List<be.reynvdc.pokedex.core.client.appwise.model.Type>): List<Type> {
            return types.map { Type(
                slot= it.slot,
                type = Type.TypeName(name = it.type.name)
            ) }
        }

        private fun toSprites(sprites: be.reynvdc.pokedex.core.client.appwise.model.Sprite): Sprite {
            return Sprite(sprites.front_default)
        }
    }
}