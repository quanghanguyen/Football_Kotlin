package com.example.football_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

//        val button:Button = findViewById(R.id.btnClickme)
//        button.setOnClickListener{
//            val intent = Intent(this@MainActivity, DemoActivity::class.java)
//            startActivity(intent)
//        }
    }
}