package com.example.football_kotlin.L1.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.football_kotlin.L1.FragmentL1.L1ChartFragment
import com.example.football_kotlin.L1.FragmentL1.L1TeamsFragment

class ViewPagerAdapterL1 (fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {

        return when (position){
            0 -> {
                L1TeamsFragment()
            }
            1 -> {
                L1ChartFragment()
            }
            else -> {
                Fragment()
            }
        }

    }


}