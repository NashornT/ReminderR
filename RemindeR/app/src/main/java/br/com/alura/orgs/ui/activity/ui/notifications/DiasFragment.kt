package br.com.alura.orgs.ui.activity.ui.notifications

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.alura.orgs.databinding.FragmentDiasBinding
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class NotificationsFragment : Fragment() {

    private var _binding: FragmentDiasBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentDiasBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val current = LocalDate.now().toString()

        val button = binding.button
        val dia = binding.txtData

        verificador(current,button,dia)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun verificador(data:String, btn:Button, txt:TextView){

        val dia :Int = data.takeLast(2).toInt()
        val mes :Int = data.take(7).takeLast(2).toInt()
        val ano :Int = data.take(4).toInt()

        val lisBiss: MutableList<Int> = mutableListOf(31,28,31,30,31,30,31,31,30,31,30,31)
        val lisNBiss: MutableList<Int> = mutableListOf(31,29,31,30,31,30,31,31,30,31,30,31)


        if(ano % 4 == 0 ){
            val dias_rest = 366 - ((lisBiss.slice(0..mes-2).sum()+dia)-2)


            btn.setOnClickListener {

                txt.setText(dias_rest.toString())
            }



        }else {
            val dias_rest = 365 - ((lisNBiss.slice(0..mes - 2).sum() + dia) - 2)

            btn.setOnClickListener {

                txt.setText(dias_rest.toString())
            }

            }


    }


}
