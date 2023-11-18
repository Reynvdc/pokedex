import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.reynvdc.pokedex.mock.tagUiDataSample1
import be.reynvdc.pokedex.mock.tagUiDataSample2
import be.reynvdc.pokedex.ui.atom.indicator.IndicatorUiData
import be.reynvdc.pokedex.ui.atom.property.StatProperty
import be.reynvdc.pokedex.ui.atom.property.BaseStatPropertyUiData
import be.reynvdc.pokedex.ui.atom.property.TextProperty
import be.reynvdc.pokedex.ui.atom.property.TextPropertyUiData
import be.reynvdc.pokedex.ui.atom.property.TypeProperty
import be.reynvdc.pokedex.ui.atom.property.TypePropertyUiData

@Composable
fun CardDetailItem(title : String, modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit){
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier){
        Text(text = title, color = Color.White, fontWeight = FontWeight.Bold)
        Card(
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                content = content
            )
        }
    }
}




@Preview
@Composable
fun CardDetailItemPreview(){
    Surface(color = Color.Green) {
        CardDetailItem ("ABOUT"){
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Text(text = "Vanaf de dag dat deze Pokemon wordt geboren, zit er een plantenzaadje op zijn rug. Het zaad wordt langzaam groter")
                TypeProperty(TypePropertyUiData("Type", tagUiDataSample1, tagUiDataSample2))
                StatProperty(BaseStatPropertyUiData("HP", 55, IndicatorUiData()))
                TextProperty(TextPropertyUiData(label = "Number", textValue = "003"))
            }
        }
    }
}