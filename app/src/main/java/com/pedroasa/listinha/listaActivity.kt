package com.pedroasa.listinha

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class listaActivity : AppCompatActivity() {


    lateinit var buttonNovos: Button
    lateinit var buttonVoltar: Button
    lateinit var buttonNovoLimpeza: Button
    lateinit var buttonNovoFrios: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista)

        buttonVoltar = findViewById(R.id.buttonVoltar)

        supportFragmentManager.beginTransaction()
            .replace(R.id.FragmentsMain, produtoFragment())
            .commit()


        val buttonProdutos: Button = findViewById(R.id.buttonNovos)
        val buttonListas: Button = findViewById(R.id.buttonLimpeza)
        val buttonCarrinho: Button = findViewById(R.id.buttonFrios)

        replaceFragment(produtoFragment())

        buttonProdutos.setOnClickListener {
            replaceFragment(produtoFragment())
        }

        buttonListas.setOnClickListener {
            replaceFragment(limpezaFragment())
        }

        buttonCarrinho.setOnClickListener {
            replaceFragment(friosFragment())
        }

        buttonVoltar.setOnClickListener {
            finish()
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.FragmentsMain, fragment)
            .commit()
    }
}