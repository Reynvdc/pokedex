package be.reynvdc.pokedex.ui.components.tag

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Tag(tagUiData: TagUiData, modifier: Modifier = Modifier) {
    Text(
        text = tagUiData.text,
        modifier = modifier
            .graphicsLayer(shape = RoundedCornerShape(8.dp))
            .background(tagUiData.color, RoundedCornerShape(12.dp))
            .padding(start = 12.dp, top = 2.dp, bottom = 2.dp, end = 12.dp),
        color = Color.White,
        fontSize = 12.sp
    )

}

@Preview
@Composable
fun TagPreview(){
    Tag(TagUiData("Water", Color.Blue))
}