package be.reynvdc.pokedex.ui.organism.mapper

import androidx.compose.ui.graphics.Color
import be.reynvdc.pokedex.core.service.model.Type
import be.reynvdc.pokedex.ui.components.tag.TagUiData
import java.util.Locale

class TypeMapper {
    companion object {

        fun  toTagUiData(type: Type): TagUiData {
            return TagUiData(
                text = type.type.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() },
                color = toColor(type.type)
            )
        }
        fun toColor(type: Type.TypeName): Color {
            return when (type.name) {
                "grass" -> Color.Green
                "poison" -> Color.Magenta
                "fire" -> Color.Red
                "flying" -> Color.Gray
                "normal" -> Color.LightGray
                "bug" -> Color.Green
                "electric" -> Color.Yellow
                "ground" -> Color.DarkGray
                "fairy" -> Color.Magenta
                "water" -> Color.Blue
                "fighting" -> Color.DarkGray
                "rock" -> Color.DarkGray
                "psychic" -> Color.Magenta
                "ghost" -> Color.Magenta
                "steel" -> Color.DarkGray
                "ice" -> Color.Blue
                "dragon" -> Color.Blue
                else -> Color.Unspecified
            }
        }
    }
}