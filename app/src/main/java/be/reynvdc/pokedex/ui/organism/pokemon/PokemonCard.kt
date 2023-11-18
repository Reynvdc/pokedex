package be.reynvdc.pokedex.ui.organism.pokemon

import CardDetailItem
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.reynvdc.pokedex.R
import be.reynvdc.pokedex.mock.pokemonAboutCardUiData
import be.reynvdc.pokedex.mock.pokemonStatsCardUiData
import be.reynvdc.pokedex.ui.atom.property.Stat100BasedAverageIndicatorPropertyUiData
import be.reynvdc.pokedex.ui.atom.property.StatProperty
import be.reynvdc.pokedex.ui.atom.property.TextProperty
import be.reynvdc.pokedex.ui.atom.property.TextPropertyUiData
import be.reynvdc.pokedex.ui.atom.property.TypeProperty
import be.reynvdc.pokedex.ui.atom.property.TypePropertyUiData

@Composable
fun PokemonAboutCard(pokemonAboutCardUiData: PokemonAboutCardUiData, modifier: Modifier = Modifier) {
    CardDetailItem (stringResource(id = R.string.pokemon_detail_about_card_title,), modifier = modifier){
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text(text = pokemonAboutCardUiData.text)
            if(pokemonAboutCardUiData.tag1 != null && pokemonAboutCardUiData.tag2 !=null){
                TypeProperty(
                    TypePropertyUiData(
                        stringResource(id = R.string.pokemon_detail_type),
                        pokemonAboutCardUiData.tag1!!,
                        pokemonAboutCardUiData.tag2!!
                ))
            }
            TextProperty(TextPropertyUiData( stringResource(id = R.string.pokemon_detail_number),pokemonAboutCardUiData.number.toString()))
            if(pokemonAboutCardUiData.height > 0){
                val heightString = "${pokemonAboutCardUiData.height} m"
                TextProperty(TextPropertyUiData( stringResource(id = R.string.pokemon_detail_height),heightString))
            }
            if(pokemonAboutCardUiData.weight > 0){
                val weightString = "${pokemonAboutCardUiData.weight} kg"
                TextProperty(TextPropertyUiData( stringResource(id = R.string.pokemon_detail_weight),weightString))
            }
            TextProperty(TextPropertyUiData( stringResource(id = R.string.pokemon_detail_category),pokemonAboutCardUiData.category))
            TextProperty(TextPropertyUiData( stringResource(id = R.string.pokemon_detail_sex),pokemonAboutCardUiData.sex))
            TextProperty(TextPropertyUiData( stringResource(id = R.string.pokemon_detail_ability),pokemonAboutCardUiData.ability))
        }
    }
}

@Composable
fun PokemonStatsCard(pokemonStatsCardUiData: PokemonStatsCardUiData, modifier: Modifier = Modifier) {
    CardDetailItem (stringResource(id = R.string.pokemon_detail_stats_card_title), modifier = modifier){
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            StatProperty(
                Stat100BasedAverageIndicatorPropertyUiData(
                    label = stringResource(id = R.string.pokemon_detail_stats_hp),
                    number = pokemonStatsCardUiData.hp,
                    totalAverage = pokemonStatsCardUiData.median
                )
            )
            StatProperty(
                Stat100BasedAverageIndicatorPropertyUiData(
                    label = stringResource(id = R.string.pokemon_detail_stats_attack),
                    number = pokemonStatsCardUiData.attack,
                    totalAverage = pokemonStatsCardUiData.median
                )
            )
            StatProperty(
                Stat100BasedAverageIndicatorPropertyUiData(
                    label = stringResource(id = R.string.pokemon_detail_stats_defence),
                    number = pokemonStatsCardUiData.defence,
                    totalAverage = pokemonStatsCardUiData.median
                )
            )
            StatProperty(
                Stat100BasedAverageIndicatorPropertyUiData(
                    label = stringResource(id = R.string.pokemon_detail_stats_special_attack),
                    number = pokemonStatsCardUiData.specialAttack,
                    totalAverage = pokemonStatsCardUiData.median
                )
            )
            StatProperty(
                Stat100BasedAverageIndicatorPropertyUiData(
                    label = stringResource(id = R.string.pokemon_detail_stats_special_defence),
                    number = pokemonStatsCardUiData.specialDefence,
                    totalAverage = pokemonStatsCardUiData.median
                )
            )
            StatProperty(
                Stat100BasedAverageIndicatorPropertyUiData(
                    label = stringResource(id = R.string.pokemon_detail_stats_speed),
                    number = pokemonStatsCardUiData.speed,
                    totalAverage = pokemonStatsCardUiData.median
                )
            )
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