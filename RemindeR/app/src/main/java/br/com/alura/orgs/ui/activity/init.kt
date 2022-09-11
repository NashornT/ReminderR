package br.com.alura.orgs.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import br.com.alura.orgs.R
import com.google.android.material.textfield.TextInputEditText

class init : AppCompatActivity(R.layout.activity_init) {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val button = findViewById<Button>(R.id.btn_init)
        val input = findViewById<TextInputEditText>(R.id.input_init)
        var nome = input.text.toString()

        button.isEnabled = false
        changeText(input,button)
        startMain(button)

    }
    fun startMain(btn:Button){

        btn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java )
            startActivity(intent)
            Toast.makeText(this, "Bem Vindo  ", Toast.LENGTH_SHORT).show()
        }

    }

    fun changeText(txtInput:TextInputEditText, btn: Button){

        txtInput.doAfterTextChanged {
            if(it?.length!! > 5){
                btn.isEnabled = true
            }
        }

    }


}