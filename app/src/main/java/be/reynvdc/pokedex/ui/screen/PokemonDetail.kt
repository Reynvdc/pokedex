package be.reynvdc.pokedex.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import be.reynvdc.pokedex.R
import be.reynvdc.pokedex.mock.pokemonAboutCardUiData
import be.reynvdc.pokedex.mock.pokemonStatsCardUiData
import be.reynvdc.pokedex.ui.organism.pokemon.PokemonAboutCard
import be.reynvdc.pokedex.ui.organism.pokemon.PokemonStatPreview
import be.reynvdc.pokedex.ui.organism.pokemon.PokemonStatsCard
import be.reynvdc.pokedex.ui.organism.pokemon.list.ErrorScreen
import be.reynvdc.pokedex.ui.organism.pokemon.list.LoadingScreen
import be.reynvdc.pokedex.ui.organism.pokemon.list.PokemonListViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun PokemonDetailScreen(pokemonDetailUiState: PokemonDetailUiState){
    when(pokemonDetailUiState){
        is PokemonDetailUiState.Loading -> LoadingScreen()
        is PokemonDetailUiState.Success ->
            Surface (color = Color.Green){
                Column(modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(start = 16.dp, end = 16.dp)) {
                    Text(text = pokemonDetailUiState.name, fontSize = MaterialTheme.typography.titleLarge.fontSize)
                    AsyncImage(
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data(pokemonDetailUiState.imageSrc)
                            .fallback(R.drawable.pokemon1)
                            .crossfade(true)
                            .build(),
                        contentDescription = pokemonDetailUiState.name,
                        modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.FillWidth)
                    PokemonAboutCard(pokemonAboutCardUiData = pokemonDetailUiState.pokemonAboutCardUiData)
                    PokemonStatsCard(pokemonStatsCardUiData = pokemonDetailUiState.pokemonStatsCardUiData)
                }
            }
        is PokemonDetailUiState.Error -> ErrorScreen()
    }
}


@Preview
@Composable
fun PokemonDetailScreenPreview(){
    val pokemonDetailViewModel: PokemonDetailViewModel = viewModel(factory = PokemonDetailViewModel.Factory)
    PokemonDetailScreen(pokemonDetailViewModel.pokemonDetailUiState)
}