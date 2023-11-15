package be.reynvdc.pokedex.ui.atom.property

import CardDetailItem
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.reynvdc.pokedex.mock.tagUiDataSample1
import be.reynvdc.pokedex.mock.tagUiDataSample2
import be.reynvdc.pokedex.ui.atom.indicator.Indicator
import be.reynvdc.pokedex.ui.atom.indicator.IndicatorUiData
import be.reynvdc.pokedex.ui.atom.tag.Tag


@Composable
fun Property(text: String, propertyLabelWeight: Float = 0.2f, modifier: Modifier = Modifier,content: @Composable RowScope.() -> Unit){
    Row(horizontalArrangement =
    Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(propertyLabelWeight)
        ) {
            Text(text = text, color = Color.Gray)
        }
        Row(
            modifier = Modifier
                .weight(1f - propertyLabelWeight),
            content = content
        )
    }
}

@Composable
fun StatProperty(statPropertyUiData: StatPropertyUiData, modifier: Modifier = Modifier){
    Property(text = statPropertyUiData.label , modifier = modifier) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = statPropertyUiData.number.toString(), fontWeight = FontWeight.SemiBold)
            Indicator(indicatorUiData = statPropertyUiData.indicator)
        }
    }
}

@Composable
fun TypeProperty(typePropertyUiData: TypePropertyUiData, modifier: Modifier = Modifier){
    Property(text = typePropertyUiData.label,  propertyLabelWeight = 0.4f, modifier = modifier) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Tag(typePropertyUiData.tag1)
            Tag(typePropertyUiData.tag2)
        }
    }
}

@Composable
fun TextProperty(textPropertyUiData: TextPropertyUiData, modifier: Modifier = Modifier){
    Property(text = textPropertyUiData.label, propertyLabelWeight = 0.4f, modifier = modifier) {
        Text(text = textPropertyUiData.textValue, fontWeight = FontWeight.SemiBold)
    }
}



@Preview
@Composable
fun PropertyPreview(){
    CardDetailItem("TITLE") {
        TypeProperty(TypePropertyUiData("TYPE", tagUiDataSample1, tagUiDataSample2))
        TextProperty(TextPropertyUiData("Number", "003"))
        StatProperty(StatPropertyUiData("HP", 55, IndicatorUiData()))
    }
}