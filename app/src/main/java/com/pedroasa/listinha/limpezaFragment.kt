package com.pedroasa.listinha

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pedroasa.listinha.adapters.ProdutoAdapter
import com.pedroasa.listinha.models.Produto

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private val listaDeLimpeza = mutableListOf(
    Produto("Sabão", "5.50", "10"),
    Produto("Detergente", "3.00", "5"),
    Produto("Shampoo", "12.75", "7"),
    Produto("Creme Dental", "8.30", "4"),
    Produto("Água Sanitária", "6.20", "6")
)

class limpezaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.fragment_limpeza, container, false)

        // Configurar RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.limpeza)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ProdutoAdapter(listaDeLimpeza)

        return view

    }
}