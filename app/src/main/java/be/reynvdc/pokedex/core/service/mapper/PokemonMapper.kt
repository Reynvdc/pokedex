package be.reynvdc.pokedex.core.service.mapper

import be.reynvdc.pokedex.core.client.appwise.model.AppwisePokemon
import be.reynvdc.pokedex.core.client.pokeapi.model.AbilityWrapper
import be.reynvdc.pokedex.core.client.pokeapi.model.MoveWrapper
import be.reynvdc.pokedex.core.client.pokeapi.model.PokeApiPokemon
import be.reynvdc.pokedex.core.service.model.Ability
import be.reynvdc.pokedex.core.service.model.Move
import be.reynvdc.pokedex.core.service.model.Pokemon
import be.reynvdc.pokedex.core.service.model.Sprites
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

        fun toPokemon(pokeApiPokemon: PokeApiPokemon) : Pokemon {
            return Pokemon(
                id = pokeApiPokemon.id,
                name = pokeApiPokemon.name,
                sprites = toSprites(pokeApiPokemon.sprites),
                types = toTypeList(pokeApiPokemon.types),
                height = pokeApiPokemon.height,
                weight = pokeApiPokemon.weight,
                abilities = toAbilites(pokeApiPokemon.abilities),
                moves = toMoves(pokeApiPokemon.moves)
            )
        }

        private fun toAbilites(abilities: List<AbilityWrapper>): List<Ability> {
            return abilities.map { toAbility(it) }
        }

        private fun toAbility(abilityWrapper: AbilityWrapper) : Ability{
            return Ability(
                name = abilityWrapper.ability.name
            )
        }

        private fun toTypeList (types: List<be.reynvdc.pokedex.core.client.appwise.model.Type>): List<Type> {
            return types.map { Type(
                slot= it.slot,
                type = Type.TypeName(name = it.type.name)
            ) }
        }

        private fun toSprites(sprites: be.reynvdc.pokedex.core.client.appwise.model.Sprites): Sprites {
            return Sprites(sprites.front_default)
        }

        private fun toSprites(sprites: be.reynvdc.pokedex.core.client.pokeapi.model.Sprites): Sprites {
            return Sprites(sprites.front_default)
        }

        private fun toMoves(moves: List<MoveWrapper>) : List<Move>{
            return moves.map { toMove(it) }
        }

        private fun toMove(moveWrapper: MoveWrapper): Move{
            return Move(
                name = moveWrapper.move.name,
                levelLearntAt = moveWrapper.versionGroupDetails.first().levelLearnedAt
            )
        }
    }
}