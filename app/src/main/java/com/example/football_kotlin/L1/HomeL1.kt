package com.example.football_kotlin.L1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.football_kotlin.L1.Adapter.ViewPagerAdapterL1
import com.example.football_kotlin.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeL1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_l1)
        supportActionBar?.hide()

        val tlL1:TabLayout = findViewById<View>(R.id.tlL1) as TabLayout
        val vpL1:ViewPager2 = findViewById<View>(R.id.vpL1) as ViewPager2
        val vpAdapterl1 = ViewPagerAdapterL1(supportFragmentManager, lifecycle)

        vpL1.adapter = vpAdapterl1
        TabLayoutMediator(tlL1, vpL1){tab, position ->
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