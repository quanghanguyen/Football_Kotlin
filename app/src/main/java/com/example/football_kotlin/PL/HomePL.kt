package com.example.football_kotlin.PL

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.football_kotlin.PL.Adapter.ViewPagerAdapterPL
import com.example.football_kotlin.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomePL : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_pl)
        supportActionBar?.hide()

        val tlPL:TabLayout = findViewById(R.id.tlPL)
        val vpPL:ViewPager2 = findViewById(R.id.vpPL)
        val vpAdapterPL = ViewPagerAdapterPL(supportFragmentManager, lifecycle)

        vpPL.adapter = vpAdapterPL
        TabLayoutMediator(tlPL, vpPL){tab, position ->
            when (position){
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