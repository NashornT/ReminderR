package br.com.alura.orgs.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button
import androidx.navigation.fragment.findNavController
import br.com.alura.orgs.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Clima_Frag.newInstance] factory method to
 * create an instance of this fragment.
 */
class Clima_Frag : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clima_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val web: WebView = view.findViewById(R.id.webTest)

        web.loadUrl("https://weather.com/pt-BR/clima/hoje/l/66cd4ca83a485e65ecc145a0fa8aa262e25d0e1f99eda51ea30ac4c140d552b0?par=samsung_widget")


    }
}