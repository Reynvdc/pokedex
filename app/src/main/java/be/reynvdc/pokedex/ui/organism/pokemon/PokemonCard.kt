package be.reynvdc.pokedex.ui.organism.pokemon

import CardDetailItem
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.magnifier
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.reynvdc.pokedex.mock.pokemonAboutCardUiData
import be.reynvdc.pokedex.mock.pokemonStatsCardUiData
import be.reynvdc.pokedex.ui.atom.property.StatProperty
import be.reynvdc.pokedex.ui.atom.property.TextProperty
import be.reynvdc.pokedex.ui.atom.property.TypeProperty

@Composable
fun PokemonAboutCard(pokemonAboutCardUiData: PokemonAboutCardUiData, modifier: Modifier = Modifier) {
    CardDetailItem (pokemonAboutCardUiData.title, modifier = modifier){
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text(text = pokemonAboutCardUiData.text)
            TypeProperty(pokemonAboutCardUiData.type)
            TextProperty(pokemonAboutCardUiData.number)
            TextProperty(pokemonAboutCardUiData.height)
            TextProperty(pokemonAboutCardUiData.weight)
            TextProperty(pokemonAboutCardUiData.category)
            TextProperty(pokemonAboutCardUiData.sex)
            TextProperty(pokemonAboutCardUiData.skill)
        }
    }
}

@Composable
fun PokemonStatsCard(pokemonStatsCardUiData: PokemonStatsCardUiData, modifier: Modifier = Modifier) {
    CardDetailItem (pokemonStatsCardUiData.title, modifier = modifier){
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            StatProperty(pokemonStatsCardUiData.hp)
            StatProperty(pokemonStatsCardUiData.attack)
            StatProperty(pokemonStatsCardUiData.defence)
            StatProperty(pokemonStatsCardUiData.specialAttack)
            StatProperty(pokemonStatsCardUiData.specialDefence)
            StatProperty(pokemonStatsCardUiData.speed)
            StatProperty(pokemonStatsCardUiData.total)
        }
    }
}



@Preview
@Composable
fun PokemonAboutPreview() {
    Surface(color = Color.Green) {
        PokemonAboutCard(pokemonAboutCardUiData)
    }
}

@Preview
@Composable
fun PokemonStatPreview() {
    Surface(color = Color.Green) {
        PokemonStatsCard(pokemonStatsCardUiData)
    }
}