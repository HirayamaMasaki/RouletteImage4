package com.example.rouletteimage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextTextPersonName = findViewById<EditText>(R.id.editTextTextPersonName)
        val editTextNumber1 = findViewById<EditText>(R.id.editTextNumber1)
        val editTextNumber2 = findViewById<EditText>(R.id.editTextNumber2)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val intent = Intent(this, RouletteScreen::class.java)

            val etText1 = editTextTextPersonName.text.toString()
            val etText2 = editTextNumber1.text.toString()
            val etText3 = editTextNumber2.text.toString()

            //intent変数をつなげる(第一引数はキー，第二引数は渡したい変数)
            intent.putExtra("key1",etText1)
            intent.putExtra("key2",etText2)
            intent.putExtra("key3",etText3)
            startActivity(intent)
            finish()
        }
    }
}