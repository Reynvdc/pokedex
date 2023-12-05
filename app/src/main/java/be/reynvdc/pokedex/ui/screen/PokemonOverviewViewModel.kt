package be.reynvdc.pokedex.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import be.reynvdc.pokedex.PokedexApplication
import be.reynvdc.pokedex.core.service.FavoritePokemonService
import kotlinx.coroutines.launch

class PokemonOverviewViewModel(favoritePokemonService: FavoritePokemonService) : ViewModel() {

    var favoritePokemonSize by mutableStateOf(0)

    init {
        viewModelScope.launch {
            favoritePokemonSize = favoritePokemonService.getTotal()
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PokedexApplication)
                val favoritePokemonService = application.container.favoritePokemonService
                PokemonOverviewViewModel(favoritePokemonService = favoritePokemonService)
            }
        }
    }
}