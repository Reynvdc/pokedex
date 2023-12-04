package be.reynvdc.pokedex.core.database.pokemon.mapper

import be.reynvdc.pokedex.core.service.model.Ability
import be.reynvdc.pokedex.core.service.model.Move
import be.reynvdc.pokedex.core.service.model.Pokemon
import be.reynvdc.pokedex.core.service.model.Sprites
import be.reynvdc.pokedex.core.service.model.Stats
import be.reynvdc.pokedex.core.service.model.Type

class PokemonDatabaseMapper {
    companion object{

        fun toPokemonList(pokemonList: List<Pokemon>): List<be.reynvdc.pokedex.core.database.pokemon.entities.Pokemon>{
            return  pokemonList.map { toPokemon(it) }
        }
        fun toPokemon(pokemon: Pokemon) : be.reynvdc.pokedex.core.database.pokemon.entities.Pokemon {
            val pokemonMapped = be.reynvdc.pokedex.core.database.pokemon.entities.Pokemon(
                id = pokemon.id,
                name = pokemon.name,
                sprites = toSprites(pokemon.sprites),

                height = pokemon.height,
                weight = pokemon.weight, // hectogramToKg

                stats = toStats(pokemon.stats)
            )

            pokemonMapped.types = toTypeList(pokemon.types)
            pokemonMapped.abilities = toAbilites(pokemon.abilities)
            pokemonMapped.moves = toMoves(pokemon.moves)

            return pokemonMapped
        }

        private fun toStats(stats: Stats?): be.reynvdc.pokedex.core.database.pokemon.entities.Stats? {
            return if(stats != null)
                be.reynvdc.pokedex.core.database.pokemon.entities.Stats(
                    hp = stats.hp,
                    attack = stats.attack,
                    defence = stats.defence,
                    specialAttack = stats.specialAttack,
                    specialDefence = stats.specialDefence,
                    speed = stats.speed
                )
            else null
        }

        private fun toAbilites(abilities: List<Ability>): List<be.reynvdc.pokedex.core.database.pokemon.entities.Ability> {
            return abilities.map { toAbility(it) }
        }

        private fun toAbility(ability: Ability) : be.reynvdc.pokedex.core.database.pokemon.entities.Ability {
            return be.reynvdc.pokedex.core.database.pokemon.entities.Ability(
                name = ability.name
            )
        }

        private fun toTypeList (types: List<Type>): List<be.reynvdc.pokedex.core.database.pokemon.entities.Type> {
            return types.map { be.reynvdc.pokedex.core.database.pokemon.entities.Type(
                slot= it.slot,
                type = be.reynvdc.pokedex.core.database.pokemon.entities.Type.TypeName(name = it.type.name)
            ) }
        }

        private fun toSprites(sprites: Sprites): be.reynvdc.pokedex.core.database.pokemon.entities.Sprites {
            return be.reynvdc.pokedex.core.database.pokemon.entities.Sprites(sprites.front_default)
        }

        private fun toMoves(moves: List<Move>) : List<be.reynvdc.pokedex.core.database.pokemon.entities.Move>{
            return moves.map { toMove(it) }
        }

        private fun toMove(move: Move): be.reynvdc.pokedex.core.database.pokemon.entities.Move {
            return be.reynvdc.pokedex.core.database.pokemon.entities.Move(
                name = move.name,
                levelLearntAt = move.levelLearntAt
            )
        }
    }
}