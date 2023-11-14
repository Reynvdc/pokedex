package be.reynvdc.pokedex.ui.organism.mapper

import be.reynvdc.pokedex.core.service.model.Pokemon
import be.reynvdc.pokedex.ui.components.cardlistitem.CardListUiData
import be.reynvdc.pokedex.ui.components.tag.TagUiData
import java.util.Locale

class PokemonMapper {
    companion object {
        fun toCardListItemUiData(pokemon: Pokemon) : CardListUiData{
            var sizeType = pokemon.types.size
            var tag1: TagUiData? = null
            var tag2: TagUiData? = null
            if(sizeType > 0) tag1 = TypeMapper.toTagUiData(pokemon.types[0])
            if(sizeType > 1) tag2 = TypeMapper.toTagUiData(pokemon.types[1])
            return CardListUiData(
                title = pokemon.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() },
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

    }
}