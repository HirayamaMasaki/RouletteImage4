package com.example.rouletteimage

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationSet
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class RouletteScreen : AppCompatActivity() {

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roulette_screen)

        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val text3 = findViewById<TextView>(R.id.textView3)
//        val animation1 = ResourcesCompat.getDrawable(
//            resources, R.drawable.animation1,null
//        )
        val image2 = findViewById<ImageView>(R.id.imageView2)
//        val fl = findViewById<FrameLayout>(R.id.fl)

        val etText1 = intent.getStringExtra("key1")
        val etText2 = intent.getStringExtra("key2")
        val etText3 = intent.getStringExtra("key3")

//        通常回転系
        val animSet0 = AnimationSet(true)
        animSet0.interpolator = DecelerateInterpolator()
        animSet0.fillAfter = true
        animSet0.isFillEnabled = true
        val animRotate0 = RotateAnimation(
            0.0f, -600000.0f,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f
        )
        animRotate0.duration = 250000
        animRotate0.fillAfter = true
        animSet0.addAnimation(animRotate0)

//        停止回転系
        val animSet1 = AnimationSet(true)
        animSet1.interpolator = DecelerateInterpolator()
        animSet1.fillAfter = true
        animSet1.isFillEnabled = true
        val animRotate1 = RotateAnimation(
            0.0f, -3600.0f,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f,
            RotateAnimation.RELATIVE_TO_SELF, 0.5f
        )
        animRotate1.duration = 2500
        animRotate1.fillAfter = true
        animSet1.addAnimation(animRotate1)

        text3.text = etText1
        button3.isEnabled = false

//        回すボタン
        button2.setOnClickListener {
            image2.startAnimation(animSet0)

            button2.isEnabled = false
            button3.isEnabled = true

            Handler().postDelayed( {
                if(button3.isEnabled){
                    button3.performClick()
                }
                                   }, 10000)
        }

//        止めるボタン
        button3.setOnClickListener {
            image2.startAnimation(animSet1)

            button2.isEnabled = true
            button3.isEnabled = false
        }

//        戻るボタン
        button4.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}

