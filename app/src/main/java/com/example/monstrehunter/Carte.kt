package com.example.monstrehunter

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Carte : AppCompatActivity(), SensorEventListener {
    /*
    private val paint = Paint()
    private val obstacles = ArrayList<Obstacle>()

    class Obstacle(
        val x: Int,
        val y: Int,
        val longeur: Int,
        val largeur: Int,
        val color: Int
    ) {
        fun draw(canvas: Canvas) {
            canvas.drawRect(
                x.toFloat(), y.toFloat(), (x + longeur).toFloat(),
                (y + largeur).toFloat()
            )
        }



    }


    private fun Canvas.drawRect(
        toFloat: Float,
        toFloat1: Float,
        toFloat2: Float,
        toFloat3: Float,
        color: Int
    ) {

    }

     */

    private var sensorManager: SensorManager? = null
    private var gyroscope: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.monstrehunter.R.layout.activity_carte)

        // Récupération du service SensorManager
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        // Récupération du capteur Gyroscope
        gyroscope = sensorManager!!.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
    }

    override fun onResume() {
        super.onResume()
        sensorManager!!.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL)
        }

    override fun onPause() {
        super.onPause()
        sensorManager!!.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_GYROSCOPE) {
            // Récupération des valeurs x, y et z du gyroscope
            val x = event!!.values[0]
            val y = event.values[1]
            val z = event.values[2]

            // utilisation des valeurs

            findViewById<TextView>(R.id.valeurx).text = x.toString()
            findViewById<TextView>(R.id.valeury).text = y.toString()
            findViewById<TextView>(R.id.valeurz).text = z.toString()
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }


}
