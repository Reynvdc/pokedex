package be.reynvdc.pokedex.core.client.appwise

import be.reynvdc.pokedex.core.client.appwise.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET


interface AppwisePokemonClient {

    @GET("mocks/appwise-be/pokemon/57519009/pokemon")
    fun listPokemon(): Call<List<Pokemon>>

    companion object{
        const val CLIENT_URL = "https://stoplight.io/"
    }
}