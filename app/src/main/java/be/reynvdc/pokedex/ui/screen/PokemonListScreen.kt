package be.reynvdc.pokedex.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import be.reynvdc.pokedex.R
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
                PokemonList(pokemonListUiState, onClickPokemon = onClickPokemon)
            }
        }
    }
}

@Composable
fun FavoritePokemonListScreen(
    favoritePokemonViewModel: FavoritePokemonViewModel = viewModel(factory = FavoritePokemonViewModel.Factory),
    onClickPokemon: (Int) -> Unit = {},
    navigateUp: () -> Unit = {}
){
    val favPokemonListUiState = favoritePokemonViewModel.favoritePokemonUiState.collectAsState()
    PokemonListScreen(
        title= stringResource(id = R.string.favorite_title),
        pokemonListUiState = favPokemonListUiState.value,
        onClickPokemon = onClickPokemon,
        navigateUp = navigateUp,
        modifier = Modifier.background(brush = FavoritePokemonBrush)
    )
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
