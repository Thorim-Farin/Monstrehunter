package com.example.monstrehunter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.monstrehunter.Monstre
import com.example.monstrehunter.R

class MonstreAdapter(private val monstres: List<Monstre>) :
    RecyclerView.Adapter<MonstreAdapter.MonstreViewHolder>() {

    class MonstreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomView: TextView = itemView.findViewById(R.id.monstres)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonstreViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_bestiaire, parent, false)
        return MonstreViewHolder(view)
    }

    override fun onBindViewHolder(holder: MonstreViewHolder, position: Int) {
        val monstre = monstres[position]
        holder.nomView.text = monstre.nom
    }

    override fun getItemCount() = monstres.size
}
