package be.reynvdc.pokedex.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import be.reynvdc.pokedex.PokedexApplication
import be.reynvdc.pokedex.core.service.FavoritePokemonService
import be.reynvdc.pokedex.core.service.PokemonService
import be.reynvdc.pokedex.core.service.exception.PokemonNotFoundException
import be.reynvdc.pokedex.core.service.model.Pokemon
import be.reynvdc.pokedex.core.service.util.capitalizeFirstLetter
import be.reynvdc.pokedex.ui.organism.mapper.PokemonMapper
import be.reynvdc.pokedex.ui.organism.mapper.TypeMapper
import be.reynvdc.pokedex.ui.organism.pokemon.PokemonAboutCardUiData
import be.reynvdc.pokedex.ui.organism.pokemon.PokemonStatsCardUiData
import kotlinx.coroutines.launch

sealed interface PokemonDetailUiState {
    data class Success(
        val backgroundColor: Color = Color.Transparent,
        val isFavorite : Boolean = false,
        val name: String,
        val imageSrc: String,
        val pokemonAboutCardUiData: PokemonAboutCardUiData,
        val pokemonStatsCardUiData: PokemonStatsCardUiData
    ) : PokemonDetailUiState
    object Error : PokemonDetailUiState
    object Loading : PokemonDetailUiState
}

class PokemonDetailViewModel(
    private val pokemonService: PokemonService,
    private val favoritePokemonService: FavoritePokemonService
) : ViewModel(){

    var pokemonDetailUiState: PokemonDetailUiState by mutableStateOf(PokemonDetailUiState.Loading)
        private set
    var currentPokemon: Pokemon? by mutableStateOf(null)
    var isFavorite: Boolean by mutableStateOf(false)

    fun updatePokemon(id:Int){
        pokemonDetailUiState = PokemonDetailUiState.Loading
        getPokemon(id)
    }

    fun resetPokemon(){
        pokemonDetailUiState = PokemonDetailUiState.Loading
        currentPokemon = null;
    }

    fun addCurrentPokemonToFavorite(){
        val temporaryCurrentPokemon = currentPokemon
        viewModelScope.launch {
            if(temporaryCurrentPokemon != null) {
                favoritePokemonService.add(temporaryCurrentPokemon)
                pokemonDetailUiState
                isFavorite = true
            }
        }
    }
    fun deleteCurrentPokemonFromFavorite(){
        val temporaryCurrentPokemon = currentPokemon
        viewModelScope.launch {
            if(temporaryCurrentPokemon != null) {
                favoritePokemonService.delete(temporaryCurrentPokemon)
                isFavorite = false
            }
        }
    }

    private fun getPokemon(id:Int) {
        viewModelScope.launch {
            try {
                val pokemon = pokemonService.getPokemonById(id)
                val pokemonAboutCardUiData = PokemonMapper.toPokemonAboutCardUiData(pokemon)
                val pokemonStatsCardUiData = PokemonMapper.toPokemonStatsCardUiData(pokemon)
                currentPokemon = pokemon
                isFavorite = favoritePokemonService.isFavorite(pokemon)
                pokemonDetailUiState = PokemonDetailUiState.Success(
                    backgroundColor = TypeMapper.toColor(pokemon.types.first().type),
                    isFavorite = isFavorite,
                    name = pokemon.name.capitalizeFirstLetter(),
                    imageSrc = pokemon.sprites.front_default,
                    pokemonAboutCardUiData = pokemonAboutCardUiData,
                    pokemonStatsCardUiData = pokemonStatsCardUiData
                )
            }
            catch (e: PokemonNotFoundException){
                currentPokemon = null
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
                val favoritePokemonService = application.container.favoritePokemonService
                PokemonDetailViewModel(pokemonService = pokemonService, favoritePokemonService = favoritePokemonService)
            }
        }
    }
}