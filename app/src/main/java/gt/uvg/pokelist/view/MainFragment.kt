package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gt.uvg.pokelist.R
import gt.uvg.pokelist.model.PokemonResponse
import gt.uvg.pokelist.repository.API
import okhttp3.Response
import retrofit2.Call
import javax.security.auth.callback.Callback

class MainFragment: Fragment() {

    fun getPokemonList(recyclerView: RecyclerView, view: View){
        API.retrofitService.getFirst100Pokemon().enqueue(object : Callback<PokemonResponse>,
            retrofit2.Callback<PokemonResponse> {
            override fun onResponse(
                call: Call<PokemonResponse>,
                response: retrofit2.Response<PokemonResponse>
            ) {
                val pokemonListAdapter = PokemonListAdapter(response.body()!!.results)
                recyclerView.layoutManager = LinearLayoutManager(activity)
                view.visibility = View.GONE
                recyclerView.adapter = pokemonListAdapter
                recyclerView.setHasFixedSize(true)
            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                Toast.makeText(context, "ERROR", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.VISIBLE
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        getPokemonList(recyclerView, progressBar)
        return view
    }
}