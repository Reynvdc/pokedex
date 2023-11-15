package be.reynvdc.pokedex.ui.organism.pokemon

import be.reynvdc.pokedex.ui.atom.property.TextPropertyUiData
import be.reynvdc.pokedex.ui.atom.property.TypePropertyUiData

data class PokemonAboutCardUiData  (
    var title:String,
    var text: String,
    var type: TypePropertyUiData,
    var number : TextPropertyUiData,
    var height : TextPropertyUiData,
    var weight : TextPropertyUiData,
    var category : TextPropertyUiData,
    var sex : TextPropertyUiData,
    var skill : TextPropertyUiData,
)
