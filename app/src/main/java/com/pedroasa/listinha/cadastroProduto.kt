package com.pedroasa.listinha

// Importações necessárias para a Activity

import android.content.Intent
import android.os.Bundle  // Permite acessar o estado da Activity
import android.widget.Button  // Representa um botão na interface gráfica
import android.widget.TextView  // Representa um campo de texto na interface
import androidx.activity.enableEdgeToEdge  // Ajusta a interface para telas com bordas arredondadas e notch
import androidx.appcompat.app.AppCompatActivity  // Classe base para Activities compatíveis com versões antigas do Android
import androidx.core.view.ViewCompat  // Permite compatibilidade com ajustes de interface
import androidx.core.view.WindowInsetsCompat  // Gerencia áreas de recorte e status bar da interface



// Definição da classe cadastroProduto, que herda de AppCompatActivity

class cadastroProduto : AppCompatActivity() {



    // Declaração das variáveis que representam componentes da interface gráfica

    lateinit var buttonFechar: Button  // Botão para fechar a Activity
    lateinit var textNome: TextView  // Campo de texto que exibirá a nome do produto
    lateinit var textPreco: TextView  // Campo de texto que exibirá o preco do produto
    lateinit var textQuantidade: TextView
    lateinit var buttonNovoCadastro: Button



    // Método chamado quando a Activity é criada

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)



        // Ativa o modo edge-to-edge para interface mais fluida

        enableEdgeToEdge()



        // Define o layout que será usado pela Activity

        setContentView(R.layout.activity_cadastro_produto)



        // Inicializa os componentes da interface encontrando-os pelo ID no layout XML

        buttonFechar = findViewById(R.id.button_Sair)

        textNome = findViewById(R.id.nome_produto)

        textPreco = findViewById(R.id.preco_produto)

        textQuantidade = findViewById(R.id.texto_quantidade)

        buttonNovoCadastro = findViewById(R.id.button_NovoCadastro)




        // Obtém os parâmetros enviados pela Intent

        val bundle = intent.extras  // Obtém todos os valores passados via Intent

        if (bundle != null) {  // Verifica se existem dados

            val nome = bundle.getString("nome_produto")  // Obtém o valor do parâmetro "nome"

            val preco = bundle.getString("preco_produto")  // Obtém o valor do parâmetro "preco"

            val email = bundle.getString("quantidade")  // Obtém o valor do parâmetro "email"


            textNome.text = nome  // Exibe o nome no TextView correspondente

            textPreco.text = preco  // Exibe o preco no TextView correspondente (convertendo para String)

            textQuantidade.text = email

        }



        // Define um evento de clique no botão para fechar a Activity

        buttonFechar.setOnClickListener {
            finish()  // Encerra a Activity atual e volta para a anterior
        }

        buttonNovoCadastro.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }



        // Ajusta os paddings da tela para evitar sobreposição da barra de status e outras áreas do sistema

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->

            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            insets

        }

    }

}