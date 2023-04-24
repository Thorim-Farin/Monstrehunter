package com.example.monstrehunter

import android.content.Intent
import android.os.Bundle
import android.provider.BaseColumns
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.monstrehunter.Monstre
import com.example.monstrehunter.R
import kotlinx.coroutines.flow.internal.NoOpContinuation.context
import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class Bestiaire : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bestiaire)

        // Récupère tout les monstre capturés dans la liste des monstre
        val dbHelper = DatabaseHelper(this)
        val db = dbHelper.readableDatabase
        val projection = arrayOf(BaseColumns._ID, "nom", "type", "niveau")
        val selection = "capture = ?"
        val selectionArgs = arrayOf("1")
        val sortOrder = "niveau DESC"
        val cursor = db.query(
            "monstres", // La table à interroger
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
                val monstre = Monstre(nom, type, niveau)
                monstresCapture.add(monstre)
            }
        }
        cursor.close()

        // Affiche la liste de monstres capturés dans une RecyclerView ou une ListView
        val listView = findViewById<View>(R.id.monstresCpature) as RecyclerView
        listView.adapter = MonstreAdapter(monstresCapture)
        listView.layoutManager = LinearLayoutManager(this)

        // ...
    }

}

