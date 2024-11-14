package com.example.gregorycedraz_rm94404.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gregorycedraz_rm94404.R
import com.example.gregorycedraz_rm94404.model.DicaModel

class DicasAdapter (private val onItemRemoved: (DicaModel) -> Unit) :
    RecyclerView.Adapter<DicasAdapter.DicaViewHolder>() {

    private var dicas = listOf<DicaModel>()

    inner class DicaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val titulo = view.findViewById<TextView>(R.id.textViewItemTitulo)
        val descricao = view.findViewById<TextView>(R.id.textViewItemDescricao)

        fun bind(item: DicaModel) {
            titulo.text = item.titulo
            descricao.text = item.descricao
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DicaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dica_layout, parent, false)
        return DicaViewHolder(view)
    }

    override fun getItemCount(): Int = dicas.size

    override fun onBindViewHolder(holder: DicaViewHolder, position: Int) {
        val dica = dicas[position]
        holder.bind(dica)
    }

    fun updateDicas(newDicas: List<DicaModel>) {
        dicas = newDicas
        notifyDataSetChanged()
    }
}