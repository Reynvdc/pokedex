package be.reynvdc.pokedex.core.service.util

import java.util.Locale

fun String.capitalizeFirstLetter() =
    this.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString()
    }
