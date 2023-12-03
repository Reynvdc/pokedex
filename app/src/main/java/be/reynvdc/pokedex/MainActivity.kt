package be.reynvdc.pokedex

import PokemonOverview
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import be.reynvdc.pokedex.ui.screen.PokemonDetailScreen
import be.reynvdc.pokedex.ui.screen.PokemonDetailViewModel
import be.reynvdc.pokedex.ui.theme.PokedexTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
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
    pokemonDetailViewModel: PokemonDetailViewModel = viewModel(factory = PokemonDetailViewModel.Factory)
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
                    PokemonOverview(onClickPokemon = {index ->
                        currentPokemonIndex = index
                        pokemonDetailViewModel.updatePokemon(currentPokemonIndex)
                        navController.navigate(PokedexScreen.DETAIL.name)
                    })
                }
                composable(route = PokedexScreen.DETAIL.name){
                    PokemonDetailScreen(
                        pokemonDetailViewModel.pokemonDetailUiState,
                        navigateUp = {
                            pokemonDetailViewModel.resetPokemon()
                            navController.navigateUp()
                        }
                    )
                }
            }
        }
    }
}

enum class PokedexScreen{
    OVERVIEW,
    DETAIL
}

