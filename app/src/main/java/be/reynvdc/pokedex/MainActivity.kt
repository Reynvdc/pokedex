package be.reynvdc.pokedex

import PokemonOverview
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import be.reynvdc.pokedex.ui.screen.PokemonDetailScreen
import be.reynvdc.pokedex.ui.screen.PokemonDetailViewModel
import be.reynvdc.pokedex.ui.theme.PokedexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController();
            val pokemonDetailViewModel: PokemonDetailViewModel = viewModel(factory = PokemonDetailViewModel.Factory)
            PokedexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = PokedexScreen.OVERVIEW.name
                    ){
                        composable(route = PokedexScreen.OVERVIEW.name){
                            PokemonOverview(onClickPokemon = {index ->
                                pokemonDetailViewModel.updatePokemon(index)
                                navController.navigate(PokedexScreen.DETAIL.name)
                            })
                        }
                        composable(route = PokedexScreen.DETAIL.name){
                            PokemonDetailScreen(pokemonDetailViewModel.pokemonDetailUiState)
                        }
                    }
                }
            }
        }
    }
}

enum class PokedexScreen{
    OVERVIEW,
    DETAIL
}

