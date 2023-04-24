package com.example.monstrehunter

class Monstre(
    val nom: String,
    val type: String,
    var niveau: Int,
    var vie: Int,
    var dommageRecus: Int
    var drop : String
) {
    fun attaque() {
        println("$nom attaque et inflige $niveau points de dégâts !")
    }

    fun prendDommage(dommage: Int) {
        vie -= dommage - dommageRecus
        println("$nom subit $dommage points de dégâts et il reste $vie points de vie.")
    }

    fun prendDrop() {
        println("$nom à lacher $drop.")
    }
}