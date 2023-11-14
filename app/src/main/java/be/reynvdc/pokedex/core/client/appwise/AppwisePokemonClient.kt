package be.reynvdc.pokedex.core.client.appwise

import be.reynvdc.pokedex.core.client.appwise.model.AppwisePokemon
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.GET


interface AppwisePokemonClient {

    @GET("mocks/appwise-be/pokemon/57519009/pokemon")
    suspend fun listPokemon(): List<AppwisePokemon>

    companion object{
        const val CLIENT_URL = "https://stoplight.io/"
        private var retrofit = Retrofit.Builder()
            .baseUrl(AppwisePokemonClient.CLIENT_URL)
            .addConverterFactory(
                JacksonConverterFactory.create(
                    ObjectMapper().registerModule(
                KotlinModule.Builder().build()
            )))
            .build()

        fun create(): AppwisePokemonClient{
            return retrofit.create(AppwisePokemonClient::class.java)
        }
    }
}