package com.example.monstrehunter

class Ingredient(
    val nom: String,
    val description: String
) {
    fun utiliser() {
        println("Vous utilisez un(e) $nom.")
    }
}
