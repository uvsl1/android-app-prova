package com.pedroasa.listinha

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pedroasa.listinha.adapters.ProdutoAdapter
import com.pedroasa.listinha.models.Produto

private val listaDeLimpeza = mutableListOf(
    Produto("Sabão", "5.50", "10"),
    Produto("Detergente", "3.00", "5"),
    Produto("Shampoo", "12.75", "7"),
    Produto("Creme Dental", "8.30", "4"),
    Produto("Água Sanitária", "6.20", "6"),
    Produto("Esponja", "2.50", "15"),
    Produto("Desinfetante", "9.99", "3"),
    Produto("Lustra Móveis", "14.50", "2"),
    Produto("Pano de Chão", "4.80", "8"),
    Produto("Sabonete Líquido", "7.25", "5")
)

class limpezaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.fragment_limpeza, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.limpeza)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ProdutoAdapter(listaDeLimpeza)

        return view

    }
}