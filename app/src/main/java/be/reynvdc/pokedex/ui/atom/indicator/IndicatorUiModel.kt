package be.reynvdc.pokedex.ui.atom.indicator

import androidx.compose.ui.graphics.Color

data class IndicatorUiModel(
    val color:Color = Color.Green,
    val progress: Float = 0.5f
)
