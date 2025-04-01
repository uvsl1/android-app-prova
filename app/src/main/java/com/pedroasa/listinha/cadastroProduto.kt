package com.pedroasa.listinha


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class cadastroProduto : AppCompatActivity() {

    lateinit var buttonFechar: Button
    lateinit var textNome: TextView
    lateinit var textPreco: TextView
    lateinit var textQuantidade: TextView
    lateinit var buttonNovoCadastro: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_cadastro_produto)

        buttonFechar = findViewById(R.id.button_Sair)
        textNome = findViewById(R.id.nome_produto)
        textPreco = findViewById(R.id.preco_produto)
        textQuantidade = findViewById(R.id.texto_quantidade)
        buttonNovoCadastro = findViewById(R.id.button_NovoCadastro)

        val bundle = intent.extras  // Obtém todos os valores passados via Intent

        if (bundle != null) {  // Verifica se existem dados

            val nome = bundle.getString("nome_produto")  // Obtém o valor do parâmetro "nome"
            val preco = bundle.getString("preco_produto")  // Obtém o valor do parâmetro "preco"
            val email = bundle.getString("quantidade")  // Obtém o valor do parâmetro "email"

            textNome.text = nome  // Exibe o nome no TextView correspondente
            textPreco.text = preco  // Exibe o preco no TextView correspondente (convertendo para String)
            textQuantidade.text = email
        }

        buttonFechar.setOnClickListener {
            finish()  // Encerra a Activity atual e volta para a anterior
        }

        buttonNovoCadastro.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}