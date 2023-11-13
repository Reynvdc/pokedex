package be.reynvdc.pokedex.ui

import androidx.compose.ui.graphics.Color
import be.reynvdc.pokedex.R
import be.reynvdc.pokedex.ui.components.carditem.CardItemUiData
import be.reynvdc.pokedex.ui.components.cardlistitem.CardListUiData
import be.reynvdc.pokedex.ui.components.tag.TagUiData

val tagUiDataSample1 = TagUiData("water", Color.Blue)
val tagUiDataSample2 = TagUiData("Psychic", Color.Magenta)

val cardListUiDataSample1 = CardListUiData(
    "bulbasaur",
    "Nr1",
    R.drawable.pokemon1,
    {},
    tagUiDataSample1,
    tagUiDataSample2
)

val cardListUiDataSampleList1= listOf(
    cardListUiDataSample1,
    cardListUiDataSample1,
    cardListUiDataSample1,
    cardListUiDataSample1,
    cardListUiDataSample1,
    cardListUiDataSample1,
    cardListUiDataSample1
)

val cardItemUiDataSample1 = CardItemUiData(
    "Mijn team",
    "4 pokemons",
    R.drawable.pokeball_white,
    {},
    Color(55, 8, 122, 170)
)

val cardItemUiDataSample2 = CardItemUiData(
    "Favorieten",
    "12 pokemons",
    R.drawable.pokeball_white,
    {},
    Color(117, 206, 142, 170)
)