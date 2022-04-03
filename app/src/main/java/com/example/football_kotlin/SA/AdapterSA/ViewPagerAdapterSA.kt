package com.example.football_kotlin.SA.AdapterSA

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.football_kotlin.SA.Fragment.SAChartFragment
import com.example.football_kotlin.SA.Fragment.SATeamsFragment

class ViewPagerAdapterSA (fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position){
            0 -> {
                SATeamsFragment()
            }
            1 -> {
                SAChartFragment()
            }
            else -> {
                Fragment()
            }
        }
    }


}