package com.example.monstrehunter

class Rune(
    val nom: String,
    val type: String,
    var quantite: Int,
    val effet: String
) {
    fun utiliser() {
        if (quantite > 0) {
            println("Vous avez utilisé une $nom. $effet.")
            quantite--
        } else {
            println("Vous n'avez plus de $nom.")
        }
    }
}
