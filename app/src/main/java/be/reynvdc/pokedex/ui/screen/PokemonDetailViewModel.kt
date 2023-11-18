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
import be.reynvdc.pokedex.core.service.PokemonService
import be.reynvdc.pokedex.core.service.exception.PokemonNotFoundException
import be.reynvdc.pokedex.ui.organism.mapper.PokemonMapper
import be.reynvdc.pokedex.ui.organism.pokemon.PokemonAboutCardUiData
import be.reynvdc.pokedex.ui.organism.pokemon.PokemonStatsCardUiData
import kotlinx.coroutines.launch

sealed interface PokemonDetailUiState {
    data class Success(
        val name: String,
        val imageSrc: String,
        val pokemonAboutCardUiData: PokemonAboutCardUiData,
        val pokemonStatsCardUiData: PokemonStatsCardUiData
    ) : PokemonDetailUiState
    object Error : PokemonDetailUiState
    object Loading : PokemonDetailUiState
}

class PokemonDetailViewModel(private val pokemonService: PokemonService) : ViewModel(){

    var pokemonDetailUiState: PokemonDetailUiState by mutableStateOf(PokemonDetailUiState.Loading)
        private set

    init {
        getPokemon(9)
    }

    fun getPokemon(id:Int) {
        viewModelScope.launch {
            try {
                val pokemon = pokemonService.getPokemonById(id)
                val pokemonAboutCardUiData = PokemonMapper.toPokemonAboutCardUiData(pokemon)
                val pokemonStatsCardUiData = PokemonMapper.toPokemonStatsCardUiData(pokemon)
                pokemonDetailUiState = PokemonDetailUiState.Success(
                    name = pokemon.name,
                    imageSrc = pokemon.sprites.front_default,
                    pokemonAboutCardUiData = pokemonAboutCardUiData,
                    pokemonStatsCardUiData = pokemonStatsCardUiData
                )
            }
            catch (e: PokemonNotFoundException){
                pokemonDetailUiState = PokemonDetailUiState.Error
            }
        }
    }
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PokedexApplication)
                val pokemonService = application.container.pokemonService
                PokemonDetailViewModel(pokemonService = pokemonService)
            }
        }
    }
}