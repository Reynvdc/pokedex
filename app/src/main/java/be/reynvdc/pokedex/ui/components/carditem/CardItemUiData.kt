package be.reynvdc.pokedex.ui.components.carditem

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import be.reynvdc.pokedex.ui.atom.tag.TagUiData

data class CardItemUiData(
    val title:String,
    val subTitle: String,
    val imageId: Int,
    val onClick: () -> Unit,
    val color:Color? = null,
    val brush: Brush? = null
)
