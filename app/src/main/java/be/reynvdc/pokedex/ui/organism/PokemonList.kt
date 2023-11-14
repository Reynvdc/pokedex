package be.reynvdc.pokedex.ui.organism

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.reynvdc.pokedex.core.service.PokemonService
import be.reynvdc.pokedex.ui.components.cardlistitem.CardListItem
import be.reynvdc.pokedex.ui.components.cardlistitem.CardListUiData
import be.reynvdc.pokedex.ui.organism.mapper.PokemonMapper

@Composable
fun PokemonList(){
    var cardListUiDataList : List<CardListUiData> by remember { mutableStateOf(listOf()) }
    LaunchedEffect(cardListUiDataList){
        cardListUiDataList = PokemonMapper.toCardListItemUiDataList(PokemonService().getList())
    }

    LazyColumn(            verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        items(cardListUiDataList) {
            CardListItem(it)
        }
    }
}

@Preview
@Composable
fun PokemonListPreview(){
    PokemonList()
}