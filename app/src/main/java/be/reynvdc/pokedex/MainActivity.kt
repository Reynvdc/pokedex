package be.reynvdc.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import be.reynvdc.pokedex.ui.organism.PokemonList
import be.reynvdc.pokedex.mock.cardItemUiDataSample1
import be.reynvdc.pokedex.mock.cardItemUiDataSample2
import be.reynvdc.pokedex.ui.atom.SearchBar
import be.reynvdc.pokedex.ui.components.carditem.CardItem
import be.reynvdc.pokedex.ui.organism.PokemonListViewModel
import be.reynvdc.pokedex.ui.theme.PokedexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PokemonApp()
                }
            }
        }
    }
}

@Composable
@Preview
fun PokemonApp(modifier: Modifier = Modifier){
    PokedexTheme{
        Column (
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(16.dp)) {
            Text(text = "Pokedex", fontSize = 32.sp, fontWeight = FontWeight.Bold)
            SearchBar(modifier = Modifier.fillMaxWidth())
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Column(modifier = modifier.weight(1f)) {
                    CardItem(cardItemUiDataSample1)
                }
                Column(modifier = modifier.weight(1f)) {
                    CardItem(cardItemUiData = cardItemUiDataSample2)
                }
            }
            val pokemonListViewModel: PokemonListViewModel = viewModel(factory = PokemonListViewModel.Factory)
            PokemonList(pokemonListViewModel.pokemonListUiState)
        }
    }
}
