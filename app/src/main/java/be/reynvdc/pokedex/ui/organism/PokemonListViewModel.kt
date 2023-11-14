package be.reynvdc.pokedex.ui.organism

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.reynvdc.pokedex.core.service.PokemonService
import be.reynvdc.pokedex.core.service.PokemonServiceImpl
import be.reynvdc.pokedex.ui.components.cardlistitem.CardListUiData
import be.reynvdc.pokedex.ui.organism.mapper.PokemonMapper
import kotlinx.coroutines.launch

sealed interface PokemonListUiState {
    data class Success(val cardListUiDataList: List<CardListUiData>) : PokemonListUiState
    object Error : PokemonListUiState
    object Loading : PokemonListUiState
}
class PokemonListViewModel : ViewModel() {

    var pokemonListUiState: PokemonListUiState by mutableStateOf(PokemonListUiState.Loading)
        private set
    private val pokemonService: PokemonService = PokemonServiceImpl()

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
}