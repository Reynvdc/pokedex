package be.reynvdc.pokedex.core.service.mapper

import be.reynvdc.pokedex.core.client.appwise.model.AppwisePokemon
import be.reynvdc.pokedex.core.client.pokeapi.model.PokeApiPokemon
import be.reynvdc.pokedex.core.client.pokeapi.model.StatName
import be.reynvdc.pokedex.core.service.model.Ability
import be.reynvdc.pokedex.core.service.model.Move
import be.reynvdc.pokedex.core.service.model.Pokemon
import be.reynvdc.pokedex.core.service.model.Sprites
import be.reynvdc.pokedex.core.service.model.Stats
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
                weight = pokeApiPokemon.weight / 10, // hectogramToKg
                abilities = toAbilites(pokeApiPokemon.abilities),
                moves = toMoves(pokeApiPokemon.moves),
                stats = toStats(pokeApiPokemon.stats)
            )
        }

        private fun toStats(stats: List<be.reynvdc.pokedex.core.client.pokeapi.model.Stat>): Stats {
            val mappedStats = stats.associate { Pair(it.stat.name,it.baseStat) }
            return Stats(
                hp = mappedStats[StatName.HP.label] ?: 0,
                attack = mappedStats[StatName.ATTACK.label] ?: 0,
                defence = mappedStats[StatName.DEFENCE.label] ?: 0,
                specialAttack = mappedStats[StatName.SPECIAL_ATTACK.label] ?: 0,
                specialDefence = mappedStats[StatName.SPECIAL_DEFENCE.label] ?: 0,
                speed = mappedStats[StatName.SPEED.label] ?: 0,
            )
        }

        private fun toAbilites(abilities: List<be.reynvdc.pokedex.core.client.pokeapi.model.Ability>): List<Ability> {
            return abilities.map { toAbility(it) }
        }

        private fun toAbility(abilityWrapper: be.reynvdc.pokedex.core.client.pokeapi.model.Ability) : Ability{
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

        private fun toMoves(moves: List<be.reynvdc.pokedex.core.client.pokeapi.model.Move>) : List<Move>{
            return moves.map { toMove(it) }
        }

        private fun toMove(move: be.reynvdc.pokedex.core.client.pokeapi.model.Move): Move{
            return Move(
                name = move.move.name,
                levelLearntAt = move.versionGroupDetails.first().levelLearnedAt
            )
        }
    }
}