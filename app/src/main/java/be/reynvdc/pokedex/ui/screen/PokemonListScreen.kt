package be.reynvdc.pokedex.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import be.reynvdc.pokedex.mock.cardListUiDataSampleList1
import be.reynvdc.pokedex.ui.organism.AppBar
import be.reynvdc.pokedex.ui.organism.pokemon.list.PokemonList
import be.reynvdc.pokedex.ui.organism.pokemon.list.PokemonListUiState
import be.reynvdc.pokedex.ui.theme.FavoritePokemonBrush
import be.reynvdc.pokedex.ui.theme.MyTeamColor

@Composable
fun PokemonListScreen(
    title: String,
    pokemonListUiState: PokemonListUiState,
    onClickPokemon: (Int) -> Unit = {},
    navigateUp: () -> Unit = {},
    modifier:Modifier = Modifier
){
    val _state : PokemonListUiState by remember{ mutableStateOf(pokemonListUiState)}
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column {
            AppBar(
                canNavigateBack = true,
                navigateUp = navigateUp
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            ) {
                Text(text = title, fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color.White)
                PokemonList(_state, onClickPokemon = onClickPokemon)
            }
        }
    }
}

@Preview
@Composable
fun FavoritePokemonScreenPreview(){
    PokemonListScreen(
        title = "Favorites",
        PokemonListUiState.Success(
            cardListUiDataList = cardListUiDataSampleList1
        ),
        modifier = Modifier.background(brush = FavoritePokemonBrush)
    )
}

@Preview
@Composable
fun TeamScreenPreview(){
    PokemonListScreen(
        title = "My Team",
        PokemonListUiState.Success(
            cardListUiDataList = cardListUiDataSampleList1
        ),
        modifier = Modifier.background(color = MyTeamColor)
    )
}
