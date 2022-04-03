package com.example.football_kotlin.SA

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.football_kotlin.R
import com.example.football_kotlin.SA.AdapterSA.ViewPagerAdapterSA
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeSA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_sa)
        supportActionBar?.hide()

        val tlSA:TabLayout = findViewById(R.id.tlSA)
        val vpSA:ViewPager2 = findViewById(R.id.vpSA)
        val vpSAAdapter = ViewPagerAdapterSA(supportFragmentManager, lifecycle)

        vpSA.adapter = vpSAAdapter
        TabLayoutMediator(tlSA, vpSA){tab, position ->

            when (position) {
                0 -> {
                    tab.text = "TEAMS"
                }
                1 -> {
                    tab.text = "CHART"
                }
            }
        }.attach()

    }
}