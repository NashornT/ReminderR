package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutosDao
import br.com.alura.orgs.model.Produto
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = ProdutosDao()
        val valores: MutableList<Any> = mutableListOf()
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        val fab2 = findViewById<FloatingActionButton>(R.id.floatingActionButton2)
        val fab3 = findViewById<FloatingActionButton>(R.id.fab3)

        fab3.isEnabled = false

        fab.setOnClickListener {
            val intent = Intent(this, FormularioProdutoActivity::class.java)
           startActivity(intent)

            fab3.isEnabled = true

        }

        fab2.setOnClickListener {
            val intent = Intent(this, Home::class.java)
           startActivity(intent)
            Log.i("MainActivity", "onCreate: ${valores}")
        }



        fab3.setOnClickListener {

//            #TODO("O Botão de enviar ainda não foi implementado corretamente, falta fazer ele pegar dados dinamicos.")
            val sendIntent: Intent = Intent().apply {


                    valores.add(dao.buscaTodos()[0].nome)
                    valores.add(dao.buscaTodos()[0].descricao)
                    valores.add(dao.buscaTodos()[0].valor)


                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Nome da tarefa = ${valores[0]}\n Descrição = ${valores[1]}\n data = ${valores[2]}")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)

        }



    }

    override fun onResume() {
        super.onResume()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val dao = ProdutosDao()
        Log.i("MainActivity", "onCreate: ${dao.buscaTodos()}")
        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = dao.buscaTodos())

    }



}