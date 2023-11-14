package be.reynvdc.pokedex.ui.organism

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.reynvdc.pokedex.R
import be.reynvdc.pokedex.ui.components.cardlistitem.CardListItem

@Composable
fun PokemonList(pokemonListUiState: PokemonListUiState, modifier: Modifier = Modifier){
    when(pokemonListUiState) {
        is PokemonListUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is PokemonListUiState.Success ->
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                items(pokemonListUiState.cardListUiDataList) {
                    CardListItem(it)
                }
            }

        is PokemonListUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Text(text = stringResource(R.string.loading), modifier = modifier.padding(16.dp))
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
    }
}

@Preview
@Composable
fun PokemonListPreview(){
    val pokemonListViewModel: PokemonListViewModel = viewModel(factory = PokemonListViewModel.Factory)
    PokemonList(pokemonListUiState = pokemonListViewModel.pokemonListUiState)
}