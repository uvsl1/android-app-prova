package com.pedroasa.listinha.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pedroasa.listinha.R
import com.pedroasa.listinha.models.Produto

class ProdutoAdapter(private val listaProdutos: List<Produto>) :
    RecyclerView.Adapter<ProdutoAdapter.ProdutoViewHolder>() {

    class ProdutoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nome: TextView = view.findViewById(R.id.textNome)
        val preco: TextView = view.findViewById(R.id.textPreco)
        val quantidade: TextView = view.findViewById(R.id.textQuantidade)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_produto, parent, false)
        return ProdutoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        val produto = listaProdutos[position]
        holder.nome.text = produto.nome
        holder.preco.text = "Preço: R$ ${produto.preco}"
        holder.quantidade.text = "Quantidade: ${produto.quantidade}"
    }

    override fun getItemCount(): Int = listaProdutos.size
}
