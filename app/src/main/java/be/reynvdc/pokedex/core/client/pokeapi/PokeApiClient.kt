package be.reynvdc.pokedex.core.client.pokeapi

import be.reynvdc.pokedex.core.client.pokeapi.model.PokeApiPokemon
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface PokeApiClient {

    @GET("api/v2/pokemon/{id}")
    suspend fun getPokemonById(@Path("id") id:String): Call<PokeApiPokemon>

    companion object{
        const val CLIENT_URL = "https://pokeapi.co/"
        private var retrofit = Retrofit.Builder()
            .baseUrl(CLIENT_URL)
            .addConverterFactory(
                JacksonConverterFactory.create(
                    ObjectMapper()
                        .registerModule(KotlinModule.Builder().build())
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                )
            )
            .build()

        fun create(): PokeApiClient{
            return retrofit.create(PokeApiClient::class.java)
        }
    }
}