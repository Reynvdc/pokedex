package be.reynvdc.pokedex.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import be.reynvdc.pokedex.PokedexApplication
import be.reynvdc.pokedex.core.service.FavoritePokemonService
import be.reynvdc.pokedex.ui.organism.mapper.PokemonMapper
import be.reynvdc.pokedex.ui.organism.pokemon.list.PokemonListUiState
import kotlinx.coroutines.launch

class FavoritePokemonViewModel(private val favoritePokemonService: FavoritePokemonService) : ViewModel() {

    var favoritePokemonUiState: PokemonListUiState by mutableStateOf(PokemonListUiState.Loading)
        private set

    init {
        getPokemon()
    }

    fun getPokemon() {
        viewModelScope.launch {
            val pokemonList = favoritePokemonService.getFavoritePokemonList()
            val cardListUiDataList = PokemonMapper.toCardListItemUiDataList(pokemonList)
            favoritePokemonUiState = PokemonListUiState.Success(cardListUiDataList)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PokedexApplication)
                val favoritePokemonService = application.container.favoritePokemonService
                FavoritePokemonViewModel(favoritePokemonService = favoritePokemonService)
            }
        }
    }
}