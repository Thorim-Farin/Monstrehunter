package com.example.monstrehunter
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.View
import java.util.*

class Carte(context: Context) : View(context) {

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
                (y + largeur).toFloat(), color
            )
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carte)

    }

    private fun Canvas.drawRect(
        toFloat: Float,
        toFloat1: Float,
        toFloat2: Float,
        toFloat3: Float,
        color: Int
    ) {

    }
}
