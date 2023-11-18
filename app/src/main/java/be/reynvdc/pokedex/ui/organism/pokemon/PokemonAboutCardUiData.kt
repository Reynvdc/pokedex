package be.reynvdc.pokedex.ui.organism.pokemon

import be.reynvdc.pokedex.ui.atom.tag.TagUiData

data class PokemonAboutCardUiData  (
    var text: String,
    var tag1: TagUiData?,
    var tag2: TagUiData?,
    var number : Int,
    var height : Float,
    var weight : Float,
    var category : String,
    var sex : String,
    var ability : String,
)
