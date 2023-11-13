package be.reynvdc.pokedex.core.service

import be.reynvdc.pokedex.core.client.appwise.AppwisePokemonClient
import be.reynvdc.pokedex.core.client.appwise.model.Pokemon
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

// TODO move to
class PokemonService{

    private val retrofit = Retrofit.Builder()
        .baseUrl(AppwisePokemonClient.CLIENT_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private val client = retrofit.create(AppwisePokemonClient::class.java)

    fun getList() : List<Pokemon>{
        //TODO map to outgoing service object
        return client.listPokemon().execute().body() ?: listOf()
    }
}