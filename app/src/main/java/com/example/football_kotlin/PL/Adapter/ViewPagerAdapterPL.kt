package com.example.football_kotlin.PL.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.football_kotlin.PL.FragmentPL.ChartPLFragment
import com.example.football_kotlin.PL.FragmentPL.TeamsPLFragment

class ViewPagerAdapterPL(fragmentManager: FragmentManager , lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> {
                TeamsPLFragment()
            }
            1 -> {
                ChartPLFragment()
            }
            else -> {
                Fragment()
            }
        }
    }


}