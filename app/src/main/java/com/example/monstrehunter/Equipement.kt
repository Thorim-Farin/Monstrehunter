package com.example.monstrehunter

class Equipement(
    val nom: String,
    var pointArmure: Int,
    var pointResistanceMagique: Int,
    val partieDuCorps: String,
    var emplacementsDeRune: MutableList<Rune>,
    var maxRune : Int = 0
) {
    // mêtre le nombre de rune dans le constructeur

    fun ajouterRune(rune: Rune) {
        if (emplacementsDeRune.size <= maxRune) {
            emplacementsDeRune.add(rune)
            println("Vous avez équipé une ${rune.nom} sur votre $nom.")
        } else {
            println("Vous n'avez plus d'emplacement de rune disponible sur votre $nom.")
        }
    }

    fun enleverRune(index: Int) {
        if (index < emplacementsDeRune.size) {
            val runeEnlevee = emplacementsDeRune.removeAt(index)
            println("Vous avez enlevé une ${runeEnlevee.nom} de votre $nom.")
        } else {
            println("L'emplacement de rune spécifié n'existe pas sur votre $nom.")
        }
    }
}

