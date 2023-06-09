package com.example.monstrehunter
import android.content.Context
import com.example.monstrehunter.Bestiaire
import com.example.monstrehunter.Carte

import com.example.monstrehunter.Profil
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.content.res.Resources
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val REQUEST_PERMISSIONS_CODE = 123
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.BODY_SENSORS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                arrayOf(
                    android.Manifest.permission.READ_EXTERNAL_STORAGE,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    android.Manifest.permission.ACCESS_FINE_LOCATION,
                    android.Manifest.permission.ACCESS_COARSE_LOCATION,
                    android.Manifest.permission.BODY_SENSORS),
                REQUEST_PERMISSIONS_CODE)
        }


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
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
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
                        vibrator.vibrate(VibrationEffect.createOneShot(1000, 200))
                    }
                    R.id.inventaire -> {
                        val intent = Intent(this, Inventaire::class.java)
                        startActivity(intent)
                        vibrator.vibrate(VibrationEffect.createOneShot(1000, 100))
                    }
                    R.id.bestiaire -> {
                        val intent = Intent(this, Bestiaire::class.java)
                        startActivity(intent)
                        vibrator.vibrate(VibrationEffect.createOneShot(1000, 50))
                    }
                    R.id.carte -> {
                        val intent = Intent(this, Carte::class.java)
                        startActivity(intent)
                        vibrator.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE))
                    }
                }
            }
        }
    }

    private val Int.dp: Int
        get() = (this / Resources.getSystem().displayMetrics.density).toInt()



}