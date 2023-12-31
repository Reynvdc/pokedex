package be.reynvdc.pokedex.mock

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import be.reynvdc.pokedex.R
import be.reynvdc.pokedex.ui.atom.tag.TagUiData
import be.reynvdc.pokedex.ui.components.carditem.CardItemUiData
import be.reynvdc.pokedex.ui.components.cardlistitem.CardListUiData
import be.reynvdc.pokedex.ui.organism.pokemon.PokemonAboutCardUiData
import be.reynvdc.pokedex.ui.organism.pokemon.PokemonStatsCardUiData

val tagUiDataSample1 = TagUiData("water", Color.Blue)
val tagUiDataSample2 = TagUiData("Psychic", Color.Magenta)
val tagUiDataSample3 = TagUiData("Fire", Color.Red)
val tagUiDataSample4 = TagUiData("Flying", Color.LightGray)

val cardListUiDataSample1 = CardListUiData(
    2,
    "yvysaur",
    "Nr2",
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png",
    {},
    tagUiDataSample1,
    tagUiDataSample2
)

val cardListUiDataSampleList1= listOf(
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
    color = Color(55, 8, 122,170)
)

val cardItemUiDataSample2 = CardItemUiData(
    "Favorieten",
    "12 pokemons",
    R.drawable.pokeball_white,
    {},
    //gradient colors: #5ACCA1 to #27CFCE
    brush = Brush.horizontalGradient(listOf(Color(0x5ACCA1).copy(alpha = 0.8f), Color(0x27CFCE).copy(alpha = 0.6f)))
)

val pokemonAboutCardUiData = PokemonAboutCardUiData(
    text = "Obviously prefers hot places. When it rains, steam is said to spout from the tip of its tail.",
    tag1 = tagUiDataSample3,
    tag2 = tagUiDataSample4,
    number = 4,
    height = 0.7f,
    weight = 6.8f,
    category = "Seed",
    sex = "Male/Female",
    ability ="Burning tail",
)

val pokemonStatsCardUiData = PokemonStatsCardUiData(
    hp = 45,
    attack = 60,
    defence = 48,
    specialAttack = 65,
    specialDefence = 65,
    speed = 45,
    median = 90
)