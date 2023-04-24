package com.example.monstrehunter
import Bestiaire
import Carte

import Inventaire
import Profil
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.content.res.Resources
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val title = findViewById<TextView>(R.id.titre)
        title.text = "Monstre Hunter"
        title.gravity = Gravity.CENTER
        title.textSize = 40F
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels
        title.layoutParams.width = width

        val profilButton = findViewById<Button>(R.id.profil)
        val inventaireButton = findViewById<Button>(R.id.inventaire)
        val bestiaireButton = findViewById<Button>(R.id.bestiaire)
        val carteButton = findViewById<Button>(R.id.carte)

        val buttons = listOf(profilButton, inventaireButton, bestiaireButton, carteButton)

        for (button in buttons) {
            button.layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
            button.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
            button.gravity = Gravity.CENTER
            button.setPadding(0, 16.dp, 0, 16.dp)
            button.setOnClickListener {
                when(button.id) {
                    R.id.profil -> {
                        val intent = Intent(this, Profil::class.java)
                        startActivity(intent)
                    }
                    R.id.inventaire -> {
                        val intent = Intent(this, Inventaire::class.java)
                        startActivity(intent)
                    }
                    R.id.bestiaire -> {
                        val intent = Intent(this, Bestiaire::class.java)
                        startActivity(intent)
                    }
                    R.id.carte -> {
                        val intent = Intent(this, Carte::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }

    private val Int.dp: Int
        get() = (this / Resources.getSystem().displayMetrics.density).toInt()



}