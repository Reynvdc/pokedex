package be.reynvdc.pokedex.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import be.reynvdc.pokedex.ui.organism.pokemon.list.PokemonList

@Composable
fun FavoritePokemon(modifier:Modifier = Modifier, onClickPokemon: (Int) -> Unit = {}){
    val favoritePokemonViewModel: FavoritePokemonViewModel = viewModel(factory = FavoritePokemonViewModel.Factory)
    PokemonList(favoritePokemonViewModel.favoritePokemonUiState, onClickPokemon = onClickPokemon)
}