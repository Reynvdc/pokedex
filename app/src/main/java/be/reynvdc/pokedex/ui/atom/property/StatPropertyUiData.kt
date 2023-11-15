package be.reynvdc.pokedex.ui.atom.property

import androidx.compose.ui.graphics.Color
import be.reynvdc.pokedex.ui.atom.indicator.IndicatorUiData

data class StatPropertyUiData (
    val label: String,
    val number: Int,
    val indicator: IndicatorUiData
)

