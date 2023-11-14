import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.reynvdc.pokedex.ui.atom.indicator.Indicator
import be.reynvdc.pokedex.ui.atom.indicator.IndicatorUiModel
import be.reynvdc.pokedex.ui.components.statindicator.StatIndicator
import be.reynvdc.pokedex.ui.components.statindicator.StatIndicatorListPreview

@Composable
fun CardDetailItem(modifier: Modifier = Modifier,content: @Composable ColumnScope.() -> Unit){
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier){
        Text(text = "STATISTIEKEN", color = Color.White, fontWeight = FontWeight.Bold)
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier,
            content = content)
    }
}




@Preview
@Composable
fun CardDetailItemPreview(){
    Surface(color = Color.Green) {
        CardDetailItem {
            StatIndicatorListPreview()
        }
    }
}