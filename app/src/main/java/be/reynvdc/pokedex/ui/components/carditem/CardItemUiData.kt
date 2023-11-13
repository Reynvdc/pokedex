package be.reynvdc.pokedex.ui.components.carditem

import androidx.compose.ui.graphics.Color
import be.reynvdc.pokedex.ui.components.tag.TagUiData

data class CardItemUiData(
    val title:String,
    val subTitle: String,
    val imageId: Int,
    val onClick: () -> Unit,
    val color:Color
)
