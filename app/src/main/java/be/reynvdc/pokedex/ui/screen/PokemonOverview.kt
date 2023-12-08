import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import be.reynvdc.pokedex.R
import be.reynvdc.pokedex.mock.cardItemUiDataSample1
import be.reynvdc.pokedex.ui.atom.SearchBar
import be.reynvdc.pokedex.ui.components.carditem.CardItem
import be.reynvdc.pokedex.ui.components.carditem.CardItemUiData
import be.reynvdc.pokedex.ui.organism.pokemon.list.PokemonList
import be.reynvdc.pokedex.ui.organism.pokemon.list.PokemonListViewModel
import be.reynvdc.pokedex.ui.theme.FavoritePokemonBrush
import be.reynvdc.pokedex.ui.theme.MyTeamColor
import be.reynvdc.pokedex.ui.theme.PokedexTheme

@Composable
fun PokemonOverview(
    favoritePokemonTotal: Int = 0,
    onClickPokemon: (Int) -> Unit = {},
    onClickFavorite: () -> Unit= {},
    onClickTeam: () -> Unit = {},
    modifier: Modifier = Modifier
){
    val pokemonListViewModel: PokemonListViewModel = viewModel(factory = PokemonListViewModel.Factory)
    var searchedWord by remember {
        mutableStateOf("")
    }
    Column (
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(16.dp)) {
        Text(text = stringResource(id = R.string.pokemon_overview_title), fontSize = 32.sp, fontWeight = FontWeight.Bold)
        SearchBar(
            inputValue = searchedWord,
            onSearchAction = {
                searchedWord = it
                pokemonListViewModel.updateList(it) },
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Column(modifier = modifier.weight(1f)) {
                CardItem(
                    CardItemUiData(
                        stringResource(id = R.string.team_title),
                        "4 pokemons",
                        R.drawable.pokeball_white,
                        onClick = onClickTeam,
                        color = MyTeamColor
                    )
                )
            }
            Column(modifier = modifier.weight(1f)) {
                CardItem(
                    cardItemUiData = CardItemUiData(
                        stringResource(id = R.string.favorite_title),
                        "${favoritePokemonTotal} pokemons",
                        R.drawable.pokeball_white,
                        onClick = onClickFavorite,
                        brush = FavoritePokemonBrush
                    )
                )
            }
        }
        PokemonList(pokemonListViewModel.pokemonListUiState, onClickPokemon = onClickPokemon)
    }
}

@Composable
@Preview
fun PokemonOverviewPreview(modifier: Modifier = Modifier){
    PokedexTheme{
        PokemonOverview(modifier = modifier)
    }
}
