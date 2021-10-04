package com.example.nychighschooldata.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.nychighschooldata.R

class SectionsPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
   FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int {
       return 2
    }
    override fun createFragment(position: Int): Fragment {
       lateinit var fragment: Fragment
        when(position) {
            0 -> {
                fragment = HomePageFragment()
            }
            1 -> {
                fragment = FavoritesFragment()
            }
        }
        return  fragment
    }
}