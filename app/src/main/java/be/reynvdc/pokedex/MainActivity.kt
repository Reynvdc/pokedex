package be.reynvdc.pokedex

import PokemonOverview
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import be.reynvdc.pokedex.mock.cardListUiDataSampleList1
import be.reynvdc.pokedex.ui.organism.pokemon.list.PokemonListUiState
import be.reynvdc.pokedex.ui.screen.FavoritePokemonViewModel
import be.reynvdc.pokedex.ui.screen.PokemonDetailScreen
import be.reynvdc.pokedex.ui.screen.PokemonDetailViewModel
import be.reynvdc.pokedex.ui.screen.PokemonListScreen
import be.reynvdc.pokedex.ui.screen.PokemonOverviewViewModel
import be.reynvdc.pokedex.ui.theme.FavoritePokemonBrush
import be.reynvdc.pokedex.ui.theme.MyTeamColor
import be.reynvdc.pokedex.ui.theme.PokedexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                PokedexApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokedexApp(
    navController: NavHostController = rememberNavController(),
    pokemonDetailViewModel: PokemonDetailViewModel = viewModel(factory = PokemonDetailViewModel.Factory),
    pokemonOverviewViewModel: PokemonOverviewViewModel = viewModel(factory = PokemonOverviewViewModel.Factory),
    favoritePokemonViewModel: FavoritePokemonViewModel = viewModel(factory = FavoritePokemonViewModel.Factory)

){
    var currentPokemonIndex: Int by remember {mutableStateOf(0)}

    Scaffold(
        containerColor = Color.Blue,
        contentColor = Color.Red
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {

            NavHost(
                navController = navController,
                startDestination = PokedexScreen.OVERVIEW.name
            ){
                composable(route = PokedexScreen.OVERVIEW.name){
                    PokemonOverview(
                        pokemonOverviewViewModel.favoritePokemonSize,
                        onClickPokemon = {index ->
                            currentPokemonIndex = index
                            pokemonDetailViewModel.updatePokemon(currentPokemonIndex)
                            navController.navigate(PokedexScreen.DETAIL.name)
                        },
                        onClickFavorite = {
                            navController.navigate(PokedexScreen.FAVORITE.name)
                        },
                        onClickTeam = {
                            navController.navigate(PokedexScreen.TEAM.name)
                        }
                    )
                }
                composable(route = PokedexScreen.DETAIL.name){
                    PokemonDetailScreen(
                        pokemonDetailViewModel.pokemonDetailUiState,
                        isFavorite = pokemonDetailViewModel.isFavorite,
                        navigateUp = {
                            pokemonOverviewViewModel.updateFavoritePokemonCount()
                            pokemonDetailViewModel.resetPokemon()
                            navController.navigateUp()
                        },
                        deleteFavorite = {
                            pokemonDetailViewModel.deleteCurrentPokemonFromFavorite()
                            favoritePokemonViewModel.getPokemon()
                        },
                        addFavorite = {
                            pokemonDetailViewModel.addCurrentPokemonToFavorite()
                            favoritePokemonViewModel.getPokemon()
                        }
                    )
                }
                composable(route = PokedexScreen.FAVORITE.name){
                    PokemonListScreen(
                        title= stringResource(id = R.string.favorite_title),
                        pokemonListUiState = favoritePokemonViewModel.favoritePokemonUiState,
                        onClickPokemon = {index ->
                            currentPokemonIndex = index
                            pokemonDetailViewModel.updatePokemon(currentPokemonIndex)
                            navController.navigate(PokedexScreen.DETAIL.name)
                        },
                        navigateUp = {
                            navController.navigateUp()
                        },
                        modifier = Modifier.background(brush = FavoritePokemonBrush)
                    )
                }
                composable(route = PokedexScreen.TEAM.name){
                    PokemonListScreen(
                        title= stringResource(id = R.string.team_title),
                        pokemonListUiState = PokemonListUiState.Success(cardListUiDataSampleList1),
                        onClickPokemon = {index ->
                            currentPokemonIndex = index
                            pokemonDetailViewModel.updatePokemon(currentPokemonIndex)
                            navController.navigate(PokedexScreen.DETAIL.name)
                        },
                        navigateUp = {
                            navController.navigateUp()
                        },
                        modifier = Modifier.background(color = MyTeamColor)
                    )
                }
            }
        }
    }
}
enum class PokedexScreen{
    OVERVIEW,
    DETAIL,
    FAVORITE,
    TEAM
}

