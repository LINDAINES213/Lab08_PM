package gt.uvg.pokelist.repository

import gt.uvg.pokelist.model.PokemonResponse
import retrofit2.Call
import retrofit2.http.*

interface PokemonService {

    @GET("pokemon?limit=100")
    fun getFirst100Pokemon(): Call<PokemonResponse>
}