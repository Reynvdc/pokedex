package be.reynvdc.pokedex.ui.atom.property

import CardDetailItem
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.reynvdc.pokedex.mock.tagUiDataSample1
import be.reynvdc.pokedex.mock.tagUiDataSample2
import be.reynvdc.pokedex.ui.atom.indicator.Indicator
import be.reynvdc.pokedex.ui.atom.indicator.IndicatorUiModel
import be.reynvdc.pokedex.ui.atom.tag.Tag
import be.reynvdc.pokedex.ui.atom.tag.TagUiData
import be.reynvdc.pokedex.ui.components.statindicator.StatIndicatorListPreview


@Composable
fun Property(text: String, modifier: Modifier = Modifier,content: @Composable RowScope.() -> Unit){
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
            Text(text = text, color = Color.Gray)
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.8f),
            content = content)
    }
}

@Composable
fun StatIndicator(modifier: Modifier = Modifier){
    Property(text = "HPP") {
            Text(text = "45", fontWeight = FontWeight.SemiBold)
            Indicator(indicatorUiModel = IndicatorUiModel())
    }
}

@Composable
fun TypeIndicator(modifier: Modifier = Modifier){
    Property(text = "Type") {
        Tag(tagUiDataSample1)
        Tag(tagUiDataSample2)
    }
}

@Composable
fun TextProperty(modifier: Modifier = Modifier){
    Property(text = "Nummer") {
        Text(text = "001", fontWeight = FontWeight.SemiBold)
    }
}



@Preview
@Composable
fun PropertyPreview(){
    CardDetailItem {
        TypeIndicator()
        StatIndicator()
        TextProperty()
    }
}