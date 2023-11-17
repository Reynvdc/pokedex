package be.reynvdc.pokedex.core.client.appwise

import be.reynvdc.pokedex.core.service.PokemonServiceImpl
import org.junit.Assert
import org.junit.Test

class PokeApiClient{

    @Test
    fun testApi(){
        val pokemon = PokemonServiceImpl().getPokemonById(1)
        Assert.assertNotNull(pokemon)
    }

}