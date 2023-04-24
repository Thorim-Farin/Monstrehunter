package com.example.monstrehunter
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Carte : AppCompatActivity(), SensorEventListener {

    private var sensorManager: SensorManager? = null
    private var gyroscope: Sensor? = null
    private var xPosition = 0f
    private var yPosition = 0f
    private var radius = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val carteView = CarteView(this)
        setContentView(carteView)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        gyroscope = sensorManager?.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
    }

    override fun onResume() {
        super.onResume()
        sensorManager?.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_GAME)
    }

    override fun onPause() {
        super.onPause()
        sensorManager?.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_GYROSCOPE) {
            xPosition += event.values[1] * radius
            yPosition -= event.values[0] * radius
            val carteView = findViewById<CarteView>(R.id.activity_carte_view)
            carteView?.setPosition(xPosition, yPosition)
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    inner class CarteView(context: Context?) : View(context) {

        private val paint = Paint()
        private var obstacles = mutableListOf<Obstacle>()

        init {
            paint.color = Color.BLACK
            radius = resources.getDimension(R.dimen.ball_radius)
            obstacles.add(Obstacle(200f, 200f))
            obstacles.add(Obstacle(400f, 400f))
            obstacles.add(Obstacle(600f, 600f))
        }

        fun setPosition(x: Float, y: Float) {
            xPosition = x
            yPosition = y
            invalidate()
        }

        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)

            obstacles.forEach {
                canvas?.drawCircle(it.x, it.y, radius, paint)
            }

            paint.color = Color.RED
            canvas?.drawCircle(xPosition, yPosition, radius, paint)
        }

        inner class Obstacle(val x: Float, val y: Float)
    }
}

