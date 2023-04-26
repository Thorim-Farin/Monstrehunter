package com.example.monstrehunter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.monstrehunter.Monstre
import com.example.monstrehunter.R
import java.text.FieldPosition

class MonstreAdapter(val monstres: List<Monstre>, val context: Context):
    RecyclerView.Adapter<MonstreAdapter.MonstreViewHolder>() {

    inner class MonstreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomMonstre: TextView = itemView.findViewById(R.id.monstresCpature)

        fun bindData(monstres: Monstre, position: Int) {
            nomMonstre.text = monstres.nom
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonstreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_bestiaire, parent, false)
        return MonstreViewHolder(view)
    }

    override fun onBindViewHolder(holder: MonstreViewHolder, position: Int) {
        holder.bindData(monstres[position], position)
    }

    override fun getItemCount(): Int {
        return monstres.size
    }

}
