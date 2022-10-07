package gt.uvg.pokelist.repository

import com.squareup.moshi.Moshi
import gt.uvg.pokelist.model.Pokemon
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
val retrofit: Retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl("https://pokeapi.co/").build()

object API{
    val retrofitService: PokemonService by lazy{
        retrofit.create(PokemonService::class.java)
    }
}    

class PokemonRepository {
    // Obtain pokemon list from https://pokeapi.co/
}