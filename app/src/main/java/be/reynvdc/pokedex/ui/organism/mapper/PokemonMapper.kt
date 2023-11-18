package be.reynvdc.pokedex.ui.organism.mapper

import be.reynvdc.pokedex.core.service.model.Pokemon
import be.reynvdc.pokedex.core.service.util.capitalizeFirstLetter
import be.reynvdc.pokedex.ui.atom.tag.TagUiData
import be.reynvdc.pokedex.ui.components.cardlistitem.CardListUiData
import be.reynvdc.pokedex.ui.organism.pokemon.PokemonAboutCardUiData
import be.reynvdc.pokedex.ui.organism.pokemon.PokemonStatsCardUiData

class PokemonMapper {
    companion object {
        fun toCardListItemUiData(pokemon: Pokemon) : CardListUiData{
            var sizeType = pokemon.types.size
            var tag1: TagUiData? = null
            var tag2: TagUiData? = null
            if(sizeType > 0) tag1 = TypeMapper.toTagUiData(pokemon.types[0])
            if(sizeType > 1) tag2 = TypeMapper.toTagUiData(pokemon.types[1])
            return CardListUiData(
                title = pokemon.name.capitalizeFirstLetter(),
                subTitle = "Nr. ${pokemon.id}",
                imageSrc = pokemon.sprites.front_default,
                onClick = {},
                tag1 = tag1,
                tag2 = tag2,
            )
        }

        fun toCardListItemUiDataList(list: List<Pokemon>): List<CardListUiData> {
            return list.map { toCardListItemUiData(it) }
        }

        fun toPokemonAboutCardUiData(pokemon: Pokemon): PokemonAboutCardUiData {
            var sizeType = pokemon.types.size
            var tag1: TagUiData? = null
            var tag2: TagUiData? = null
            if(sizeType > 0) tag1 = TypeMapper.toTagUiData(pokemon.types[0])
            if(sizeType > 1) tag2 = TypeMapper.toTagUiData(pokemon.types[1])
            return PokemonAboutCardUiData(
                text = "TODO description",
                tag1 = tag1,
                tag2 = tag2,
                number = pokemon.id,
                height = pokemon.height ?: 0f,
                weight = pokemon.weight ?: 0f,
                category = "TODO",
                sex ="TODO",
                ability = pokemon.abilities.first().name.capitalizeFirstLetter(),

            )
        }

        fun toPokemonStatsCardUiData(pokemon: Pokemon): PokemonStatsCardUiData {
            return PokemonStatsCardUiData(
                hp = pokemon.stats?.hp ?: 0,
                attack = pokemon.stats?.attack ?: 0,
                defence = pokemon.stats?.defence ?: 0,
                specialAttack = pokemon.stats?.specialAttack ?: 0,
                specialDefence = pokemon.stats?.specialDefence ?: 0,
                speed = pokemon.stats?.speed ?: 0,
                median = pokemon.stats?.median ?: 0
            )
        }

    }
}
