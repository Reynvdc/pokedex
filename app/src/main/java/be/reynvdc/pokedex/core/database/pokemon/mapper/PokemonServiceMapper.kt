package be.reynvdc.pokedex.core.database.pokemon.mapper

import be.reynvdc.pokedex.core.service.model.Ability
import be.reynvdc.pokedex.core.service.model.Move
import be.reynvdc.pokedex.core.service.model.Pokemon
import be.reynvdc.pokedex.core.service.model.Sprites
import be.reynvdc.pokedex.core.service.model.Stats
import be.reynvdc.pokedex.core.service.model.Type

class PokemonServiceMapper {
    companion object{

        fun toPokemonList(pokemonList: List<be.reynvdc.pokedex.core.database.pokemon.entities.Pokemon>): List<Pokemon>{
            return  pokemonList.map { toPokemon(it) }
        }
        fun toPokemon(pokemon: be.reynvdc.pokedex.core.database.pokemon.entities.Pokemon) : Pokemon {
            return Pokemon(
                id = pokemon.id,
                name = pokemon.name,
                sprites = toSprites(pokemon.sprites),
                types = toTypeList(pokemon.types),
                height = pokemon.height,
                weight = pokemon.weight, // hectogramToKg
                abilities = toAbilites(pokemon.abilities),
                moves = toMoves(pokemon.moves),
                stats = toStats(pokemon.stats)
            )
        }

        private fun toStats(stats: be.reynvdc.pokedex.core.database.pokemon.entities.Stats?): Stats? {
            return if(stats != null)
                Stats(
                    hp = stats.hp,
                    attack = stats.attack,
                    defence = stats.defence,
                    specialAttack = stats.specialAttack,
                    specialDefence = stats.specialDefence,
                    speed = stats.speed
                )
            else null
        }

        private fun toAbilites(abilities: List<be.reynvdc.pokedex.core.database.pokemon.entities.Ability>): List<Ability> {
            return abilities.map { toAbility(it) }
        }

        private fun toAbility(ability: be.reynvdc.pokedex.core.database.pokemon.entities.Ability) : Ability {
            return Ability(
                name = ability.name
            )
        }

        private fun toTypeList (types: List<be.reynvdc.pokedex.core.database.pokemon.entities.Type>): List<Type> {
            return types.map { Type(
                slot= it.slot,
                type = Type.TypeName(name = it.type.name)
            ) }
        }

        private fun toSprites(sprites: be.reynvdc.pokedex.core.database.pokemon.entities.Sprites): Sprites {
            return Sprites(sprites.front_default)
        }

        private fun toMoves(moves: List<be.reynvdc.pokedex.core.database.pokemon.entities.Move>) : List<Move>{
            return moves.map { toMove(it) }
        }

        private fun toMove(move: be.reynvdc.pokedex.core.database.pokemon.entities.Move): Move {
            return Move(
                name = move.name,
                levelLearntAt = move.levelLearntAt
            )
        }
    }
}