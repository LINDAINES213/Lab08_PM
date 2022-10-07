package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.R
import gt.uvg.pokelist.model.Pokemon

class DetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        val list: DetailFragmentArgs by navArgs()
        val imageview2 = view?.findViewById<ImageView>(R.id.imageView2)
        val imageview3 = view?.findViewById<ImageView>(R.id.imageView3)
        val imageview4 = view?.findViewById<ImageView>(R.id.imageView4)
        val imageview5 = view?.findViewById<ImageView>(R.id.imageView5)
        val id: Int = list.pokemonId

        Picasso.get().load(Pokemon(id, "required").imageUrlFront).into(imageview2)
        Picasso.get().load(Pokemon(id, "required").imageUrlBack).into(imageview3)
        Picasso.get().load(Pokemon(id, "required").imageUrlShinnyFront).into(imageview4)
        Picasso.get().load(Pokemon(id, "required").imageUrlShinnyBack).into(imageview5)

        return view
    }

}