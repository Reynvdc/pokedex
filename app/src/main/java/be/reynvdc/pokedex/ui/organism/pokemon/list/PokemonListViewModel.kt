package be.reynvdc.pokedex.ui.organism.pokemon.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import be.reynvdc.pokedex.core.service.PokemonService
import be.reynvdc.pokedex.PokedexApplication
import be.reynvdc.pokedex.ui.components.cardlistitem.CardListUiData
import be.reynvdc.pokedex.ui.organism.mapper.PokemonMapper
import kotlinx.coroutines.launch

sealed interface PokemonListUiState {
    data class Success(val cardListUiDataList: List<CardListUiData>) : PokemonListUiState
    object Error : PokemonListUiState
    object Loading : PokemonListUiState
}
class PokemonListViewModel(private val pokemonService: PokemonService) : ViewModel() {

    var pokemonListUiState: PokemonListUiState by mutableStateOf(PokemonListUiState.Loading)
        private set

    init {
        getPokemon()
    }

    fun getPokemon() {
        viewModelScope.launch {
            val pokemonList = pokemonService.getList()
            val cardListUiDataList = PokemonMapper.toCardListItemUiDataList(pokemonList)
            pokemonListUiState = PokemonListUiState.Success(cardListUiDataList)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PokedexApplication)
                val pokemonService = application.container.pokemonService
                PokemonListViewModel(pokemonService = pokemonService)
            }
        }
    }
}