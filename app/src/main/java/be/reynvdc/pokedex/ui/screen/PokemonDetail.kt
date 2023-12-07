package be.reynvdc.pokedex.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
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
import be.reynvdc.pokedex.ui.organism.AppBar
import be.reynvdc.pokedex.ui.organism.FavoriteIcon
import be.reynvdc.pokedex.ui.organism.pokemon.PokemonAboutCard
import be.reynvdc.pokedex.ui.organism.pokemon.PokemonStatPreview
import be.reynvdc.pokedex.ui.organism.pokemon.PokemonStatsCard
import be.reynvdc.pokedex.ui.organism.pokemon.list.ErrorScreen
import be.reynvdc.pokedex.ui.organism.pokemon.list.LoadingScreen
import be.reynvdc.pokedex.ui.organism.pokemon.list.PokemonListViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun PokemonDetailScreen(
    pokemonDetailUiState: PokemonDetailUiState,
    isFavorite: Boolean = false,
    navigateUp: ()-> Unit,
    deleteFavorite: () -> Unit,
    addFavorite: () -> Unit,
){
    when(pokemonDetailUiState){
        is PokemonDetailUiState.Loading -> LoadingScreen()
        is PokemonDetailUiState.Success ->
            Surface (color = pokemonDetailUiState.backgroundColor){
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(start = 16.dp, end = 16.dp)) {
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
                AppBar(
                    title = pokemonDetailUiState.name,
                    canNavigateBack = true,
                    color = pokemonDetailUiState.backgroundColor.copy(alpha = 0.4f),
                    navigateUp = navigateUp
                ){
                    FavoriteIcon(isFavorite, onClickFavorite = {
                        if (isFavorite) deleteFavorite()
                        else addFavorite()
                    })
                }
            }
        is PokemonDetailUiState.Error -> ErrorScreen()
    }
}


@Preview
@Composable
fun PokemonDetailScreenPreview(){
    PokemonDetailScreen(
        PokemonDetailUiState.Success(
            name = "bulba",
            imageSrc = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/8.png",
            pokemonStatsCardUiData = pokemonStatsCardUiData,
            pokemonAboutCardUiData = pokemonAboutCardUiData
        ),
        navigateUp = {},
        deleteFavorite = {},
        addFavorite = {}
    )
}