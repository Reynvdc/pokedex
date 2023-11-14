package be.reynvdc.pokedex.ui.atom.indicator

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Indicator(indicatorUiModel: IndicatorUiModel ,modifier: Modifier = Modifier){
    LinearProgressIndicator(
        modifier = modifier
            .fillMaxWidth()
            .height(8.dp)
            .clip(RoundedCornerShape(16.dp)),
        color = indicatorUiModel.color,
        trackColor = Color.LightGray ,
        progress = indicatorUiModel.progress
    )
}

@Preview
@Composable
fun IndicatorPreview(){
    Indicator(IndicatorUiModel())
}