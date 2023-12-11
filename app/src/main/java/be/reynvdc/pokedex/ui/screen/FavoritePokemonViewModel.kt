package be.reynvdc.pokedex.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import be.reynvdc.pokedex.PokedexApplication
import be.reynvdc.pokedex.core.service.FavoritePokemonService
import be.reynvdc.pokedex.ui.organism.mapper.PokemonMapper
import be.reynvdc.pokedex.ui.organism.pokemon.list.PokemonListUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoritePokemonViewModel(private val favoritePokemonService: FavoritePokemonService) : ViewModel() {

    private var _favoritePokemonUiState = MutableStateFlow<PokemonListUiState>(PokemonListUiState.Loading)
    val favoritePokemonUiState = _favoritePokemonUiState.asStateFlow()
    fun update(){
        getPokemon()
    }

    private fun getPokemon() {
        _favoritePokemonUiState.update { PokemonListUiState.Loading}
        viewModelScope.launch {
            val pokemonList = favoritePokemonService.getFavoritePokemonList()
            val cardListUiDataList = PokemonMapper.toCardListItemUiDataList(pokemonList)
            _favoritePokemonUiState.update { PokemonListUiState.Success(cardListUiDataList)}
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