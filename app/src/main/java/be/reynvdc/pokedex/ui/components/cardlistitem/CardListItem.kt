package be.reynvdc.pokedex.ui.components.cardlistitem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.reynvdc.pokedex.ui.cardListUiDataSample1
import be.reynvdc.pokedex.ui.cardListUiDataSampleList1
import be.reynvdc.pokedex.ui.components.tag.Tag
import be.reynvdc.pokedex.ui.theme.PokedexTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardListItem(cardListUiData: CardListUiData, modifier: Modifier = Modifier){
    Card() {
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Row(
                modifier = modifier.height(80.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = cardListUiData.imageId),
                    contentDescription = cardListUiData.title,
                    contentScale = ContentScale.FillWidth,
                    modifier = modifier
                        .fillMaxHeight()
                        .aspectRatio(1f)
                        .clip(RectangleShape) ,
                )
                Column(
                    modifier
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center) {
                    Text(
                        text = cardListUiData.title,
                        fontWeight = FontWeight.Bold
                    )
                    Text(text = cardListUiData.subTitle, )
                }
            }
            Row(horizontalArrangement = Arrangement.End, modifier = modifier.padding(16.dp)) {
                Tag(
                    tagUiData = cardListUiData.tag1,
                    modifier
                        .padding(start = 4.dp, end = 4.dp)
                )
                Tag(
                    tagUiData = cardListUiData.tag2,
                    modifier.padding(start = 4.dp, end = 4.dp)
                )
                Icon(
                    Icons.Default.KeyboardArrowRight,
                    contentDescription = "Go to pokemon",
                )
            }
        }
    }
}

@Preview
@Composable
fun PokemonCardItemPreview(){
    PokedexTheme {
        CardListItem(cardListUiDataSample1)
    }
}

@Preview
@Composable
fun PokemonCardItemListPreview(){
    PokedexTheme {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                items(cardListUiDataSampleList1) { item ->
                    CardListItem(item)
                }
            }
    }
}