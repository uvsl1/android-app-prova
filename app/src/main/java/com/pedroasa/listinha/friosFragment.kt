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

private val listaDeFrios = mutableListOf(
    Produto("Presunto", "15.00", "5"),
    Produto("Queijo Mussarela", "20.50", "7"),
    Produto("Peito de Peru", "18.30", "3"),
    Produto("Mortadela", "10.80", "10"),
    Produto("Queijo Prato", "22.40", "4"),
    Produto("Salame", "25.00", "6"),
    Produto("Linguica Calabresa", "12.90", "8"),
    Produto("Queijo Cottage", "13.70", "5"),
    Produto("Bacon", "8.50", "12"),
    Produto("Chester", "30.00", "2")
)

class friosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.fragment_frios, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.frios)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ProdutoAdapter(listaDeFrios)

        return view

    }
}