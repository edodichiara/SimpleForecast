package com.example.simpleforecast.screen.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.simpleforecast.screen.DetailTaskFragment
import com.example.simpleforecast.screen.GraphTaskFragment
import com.example.simpleforecast.screen.TodayTaskFragment

class ForecastViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TodayTaskFragment()
            1 -> DetailTaskFragment()
            2 -> GraphTaskFragment()
            else -> TodayTaskFragment()
        }
    }
}