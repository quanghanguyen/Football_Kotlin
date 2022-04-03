package com.example.football_kotlin.BL

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.football_kotlin.R

class HomeBL : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_bl)
        supportActionBar?.hide()



    }
}