package com.example.football_kotlin.BL

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.football_kotlin.BL.AdapterBL.ViewPagerAdapterBL
import com.example.football_kotlin.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeBL : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_bl)
        supportActionBar?.hide()

        val tlBL:TabLayout = findViewById<View>(R.id.tlBL) as TabLayout
        val vpBL:ViewPager2 = findViewById<View>(R.id.vpBL) as ViewPager2
        val vpAdapterBL = ViewPagerAdapterBL(supportFragmentManager, lifecycle)

        vpBL.adapter = vpAdapterBL
        TabLayoutMediator(tlBL, vpBL){tab, position ->

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