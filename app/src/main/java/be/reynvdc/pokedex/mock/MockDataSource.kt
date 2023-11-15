package be.reynvdc.pokedex.mock

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import be.reynvdc.pokedex.R
import be.reynvdc.pokedex.ui.atom.indicator.IndicatorUiData
import be.reynvdc.pokedex.ui.atom.property.StatPropertyUiData
import be.reynvdc.pokedex.ui.atom.property.TextPropertyUiData
import be.reynvdc.pokedex.ui.atom.property.TypePropertyUiData
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
    title = "ABOUT",
    text = "Obviously prefers hot places. When it rains, steam is said to spout from the tip of its tail.",
    type = TypePropertyUiData(
        label = "Type",
        tag1 = tagUiDataSample3,
        tag2 = tagUiDataSample4
    ),
    number = TextPropertyUiData("Number", "004"),
    height = TextPropertyUiData("Height", "0.7m"),
    weight = TextPropertyUiData("Weight", "6.8 kg"),
    category = TextPropertyUiData("Category", "Seed"),
    sex = TextPropertyUiData("Sex", "Male/Female"),
    skill = TextPropertyUiData("Skill", "Burning tail"),
)

val pokemonStatsCardUiData = PokemonStatsCardUiData(
    title = "Stats",
    hp = StatPropertyUiData("HP",45, IndicatorUiData(progress = 45/100f, color = Color.Red)),
    attack = StatPropertyUiData("Attack",60, IndicatorUiData(progress = 60/100f)),
    defence = StatPropertyUiData("Defence",48, IndicatorUiData(progress = 48/100f, color = Color.Red)),
    specialAttack = StatPropertyUiData("Sp. Atk",65, IndicatorUiData(progress = 65/100f)),
    specialDefence = StatPropertyUiData("Sp. Def",65, IndicatorUiData(progress = 65/100f)),
    speed = StatPropertyUiData("Attack",45, IndicatorUiData(progress = 45/100f, color = Color.Red)),
    total = StatPropertyUiData("Attack",90, IndicatorUiData(progress = 90/100f))
)