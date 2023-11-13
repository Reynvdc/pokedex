package be.reynvdc.pokedex.ui.components.carditem

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import be.reynvdc.pokedex.ui.cardItemUiDataSample1
import be.reynvdc.pokedex.ui.cardItemUiDataSample2
import be.reynvdc.pokedex.ui.theme.PokedexTheme

@Composable
fun CardItem(cardItemUiData: CardItemUiData, modifier: Modifier = Modifier){
    Card(modifier = modifier.fillMaxWidth()
        .height(120.dp)) {
        Box(modifier = modifier.fillMaxWidth()){
            val imagePainterResource = painterResource(id = cardItemUiData.imageId);
            Image(
                painter = imagePainterResource,
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = modifier
                    .padding(top = 16.dp, bottom = 16.dp)
                    .align(Alignment.CenterEnd)
                    .offset(x = 24.dp)
            )
            Box(modifier = modifier.fillMaxWidth()
                .background(cardItemUiData.color)) {
                Column(
                    modifier = modifier
                        .padding(12.dp)
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = cardItemUiData.title, fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.White)
                    Text(text = cardItemUiData.subTitle, color = Color.White)
                }
            }
        }
    }
}


@Preview
@Composable
fun CardItemPreview(){
    PokedexTheme {
        CardItem(cardItemUiDataSample1)
    }
}

@Preview
@Composable
fun CardItemRowPreview(modifier: Modifier = Modifier){
    PokedexTheme {
        Row(modifier = modifier.fillMaxWidth()) {
            Column(modifier = modifier.weight(1f)) {
                CardItem(cardItemUiDataSample1)
            }
            Column(modifier = modifier.weight(1f)){
                CardItem(cardItemUiData = cardItemUiDataSample2)
            }
        }
    }
}