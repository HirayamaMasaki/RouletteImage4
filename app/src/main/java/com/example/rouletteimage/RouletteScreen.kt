package com.example.rouletteimage

import android.content.Context
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RouletteScreen : AppCompatActivity() {

    lateinit var paint: Paint
    val dm = DisplayMetrics()
    val width = dm.widthPixels
    val height = dm.heightPixels

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roulette_screen)

        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val text3 = findViewById<TextView>(R.id.textView3)
        val fl = findViewById<FrameLayout>(R.id.fl)

        val etText1 = intent.getStringExtra("key1")
        val etText2 = intent.getStringExtra("key2")
        val etText3 = intent.getStringExtra("key3")

        text3.text = etText1
        button3.isEnabled = false

        button2.setOnClickListener {
            button2.isEnabled = false
            button3.isEnabled = true
        }

        button3.setOnClickListener {
            button2.isEnabled = true
            button3.isEnabled = false
        }

        button4.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        val myView = MyView(this)
        setContentView(myView)

    }

    // Viewを継承したクラス
    class MyView(context: Context) : View(context) {
        private var paint: Paint = Paint()

        override fun onDraw(canvas: Canvas){
            // 背景、半透明
            canvas.drawColor(Color.argb(255, 255, 255, 255))

            // 円
            paint.setColor(Color.argb(255, 0, 0, 0))
            paint.setStrokeWidth(3F)
            paint.setAntiAlias(true)
            paint.setStyle(Paint.Style.STROKE)
            // (x1,y1,r,paint) 中心x1座標, 中心y1座標, r半径
            canvas.drawCircle((width/2).toFloat(), (height/2).toFloat(), (width/2.5).toFloat(), paint)

        }
    }


//    fun onDraw(canvas: Canvas) {
//        // 背景、半透明
//        canvas.drawColor(Color.argb(255, 255, 255, 255))
//
//        // 円
//        paint.setColor(Color.argb(255, 0, 0, 0))
//        paint.setStrokeWidth(3F)
//        paint.setAntiAlias(true)
//        paint.setStyle(Paint.Style.STROKE)
//        // (x1,y1,r,paint) 中心x1座標, 中心y1座標, r半径
//        canvas.drawCircle((width/2).toFloat(), (height/2).toFloat(), (width/2.5).toFloat(), paint)
//
//    }
}

