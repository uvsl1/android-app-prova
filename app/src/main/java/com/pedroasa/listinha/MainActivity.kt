package com.pedroasa.listinha

import android.content.Intent

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pedroasa.listinha.models.Produto

class MainActivity : AppCompatActivity() {

    lateinit var buttonAbrir: Button
    lateinit var buttonSair: Button
    lateinit var buttonExibir: Button

    private val listaDeProdutos = mutableListOf<Produto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("ciclo_vida", "onCreate")
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        buttonAbrir = findViewById(R.id.button_Abrir)
        buttonSair = findViewById(R.id.button_Sair)
        buttonExibir = findViewById(R.id.button_Exibir)

        buttonAbrir.setOnClickListener {

            val intent = Intent(this, cadastroProduto::class.java)
            val nome = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.input_nome_produto).text.toString()
            val preco = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.input_preco_produto).text.toString()
            val quantidade = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.input_quantidade).text.toString()
            intent.putExtra("nome_produto", nome)
            intent.putExtra("preco_produto", preco)
            intent.putExtra("quantidade", quantidade)
            startActivity(intent)

            val novoProduto = Produto(nome, preco, quantidade)
            listaDeProdutos.add(novoProduto)
            println(listaDeProdutos)

        }

        buttonSair.setOnClickListener {
            finish()
        }

        buttonExibir.setOnClickListener {
            val intent = Intent(this, listaActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("ciclo_vida", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("ciclo_vida", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("ciclo_vida", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ciclo_vida", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("ciclo_vida", "onRestart")
    }

    override fun onDestroy() {
        Log.i("ciclo_vida", "onDestroy")
        super.onDestroy()
    }
}