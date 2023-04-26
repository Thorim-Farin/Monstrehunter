package com.example.monstrehunter

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Bestiaire : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bestiaire)
        val db = DatabaseHelper(this)
        // Crée une liste de monstres capturés
        val monstersCapture = ArrayList<Monstre>()
        db.insertMonstreCpature(Monstre("Rathalos", "Wyvern volant", 8,null,null,null,null))
        db.insertMonstreCpature(Monstre("Diablos", "Wyvern terrestre", 6,null,null,null,null))
        db.insertMonstreCpature(Monstre("Nergigante", "Wyvern aîné", 9,null,null,null,null))
        // Crée un adaptateur pour la liste de monstres capturés
        val adapter = MonstreAdapter(monstersCapture, this)

        // Lie l'adaptateur à la RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.monstresCpature)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)



        // Récupère tout les monstre capturés dans la liste des monstre
        val dbHelper = DatabaseHelper(this)
        val dbread = dbHelper.readableDatabase
        val projection = arrayOf("nom, niveau")
        val selection = "nom"
        val selectionArgs = null
        val sortOrder = "niveau DESC"
        val cursor = dbread.query(
            "MonstresCaptures", // La table à interroger
            projection, // Les colonnes à retourner
            selection, // Les colonnes pour la clause WHERE
            selectionArgs, // Les valeurs pour la clause WHERE
            null, // ne pas grouper les lignes
            null, // ne pas filtrer par groupe de lignes
            sortOrder // L'ordre de tri
        )

        //Met tout les monstres capturés dans une liste visible sur l'écran
        val monstresCapture = ArrayList<Monstre>()
        with(cursor) {
            while (moveToNext()) {
                val nom = getString(getColumnIndexOrThrow("nom"))
                val type = getString(getColumnIndexOrThrow("type"))
                val niveau = getInt(getColumnIndexOrThrow("niveau"))
                val monstre = Monstre(nom, null, niveau, null, null, null, null)
                monstresCapture.add(monstre)
            }
        }
        cursor.close()


        // Affiche la liste de monstres capturés dans une RecyclerView ou une ListView
        val listView = findViewById<View>(R.id.monstresCpature) as RecyclerView
        listView.adapter = MonstreAdapter(monstresCapture, this)
        listView.layoutManager = LinearLayoutManager(this)

    }

}

