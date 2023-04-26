package com.example.monstrehunter

import android.content.Context

class Monstre(
    val nom: String,
    val type: String?,
    var niveau: Int,
    var attaque: Int?,
    var vie: Int?,
    var dommageRecus: Int?,
    var drop: String?,
    var dejaRencontre: Boolean = false,
    var imageName: String = ""
) {
    fun attaque() {
        println("$nom attaque et inflige $attaque points de dégâts !")
    }

    fun prendDommage(dommage: Int) {
        vie = vie?.minus(dommage - dommageRecus!!)
        println("$nom subit $dommage points de dégâts et il reste $vie points de vie.")
    }

    fun prendDrop() {
        println("$nom à lacher $drop.")
    }

    fun draw(context: Context) {
        //Todo: try catching exceptions
        context.getDrawable(context.resources.getIdentifier(imageName, "drawable", context.packageName))
    }
}