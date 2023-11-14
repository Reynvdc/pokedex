package be.reynvdc.pokedex.ui.components.cardlistitem

import be.reynvdc.pokedex.ui.components.tag.TagUiData

data class CardListUiData(
    val title:String,
    val subTitle: String,
    val imageSrc: String,
    val onClick: () -> Unit,
    val tag1: TagUiData?,
    val tag2: TagUiData?
)
