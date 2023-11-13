package be.reynvdc.pokedex.core.client.appwise

import be.reynvdc.pokedex.core.service.PokemonService
import org.junit.Assert
import org.junit.Test

class AppwisePokemonServiceTest{


    @Test
    fun addition_isCorrect() {
        val service = PokemonService()
        var list = service.getList()
        Assert.assertNotNull(list)
    }
}