package be.reynvdc.pokedex.ui.components.statindicator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.reynvdc.pokedex.ui.atom.indicator.Indicator
import be.reynvdc.pokedex.ui.atom.indicator.IndicatorUiModel

@Composable
fun StatIndicator(modifier: Modifier = Modifier){
    Row(horizontalArrangement =
        Arrangement.SpaceBetween,
        modifier = modifier
            .height(36.dp)
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.2f)
        ) {
            Text(text = "HP", color = Color.Gray)
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.8f)
        ) {
            Text(text = "45", fontWeight = FontWeight.SemiBold)
            Indicator(indicatorUiModel = IndicatorUiModel())
        }
    }
}



@Preview
@Composable
fun StatIndicatorPreview(){
    StatIndicator()
}

@Preview
@Composable
fun StatIndicatorListPreview(){
    Column(modifier = Modifier){
        StatIndicator()
        StatIndicator()
        StatIndicator()
    }
}