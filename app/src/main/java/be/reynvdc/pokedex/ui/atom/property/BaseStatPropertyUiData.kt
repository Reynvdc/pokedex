package be.reynvdc.pokedex.ui.atom.property

import androidx.compose.ui.graphics.Color
import be.reynvdc.pokedex.ui.atom.indicator.IndicatorUiData


interface StatPropertyUiData {
    val label: String
    val number: Int
    val indicator: IndicatorUiData
}
data class BaseStatPropertyUiData(
    override val label: String,
    override val number: Int,
    override val indicator: IndicatorUiData
): StatPropertyUiData

data class Stat100BasedPropertyUiData (
    override val label: String,
    override val number: Int,
    private val color: Color = Color.Green
):StatPropertyUiData{
    override val indicator = IndicatorUiData(color=color, progress = number/100f)
}
data class Stat100BasedAverageIndicatorPropertyUiData (
    override val label: String,
    override val number: Int,
    val totalAverage: Int,
    private val colorAboveAverage: Color = Color.Green,
    private val colorBelowAverage: Color = Color.Red,
):StatPropertyUiData{

    private val color: Color = if (number >= totalAverage) colorAboveAverage else colorBelowAverage
    override val indicator = IndicatorUiData(color=color, progress = number/100f)
}