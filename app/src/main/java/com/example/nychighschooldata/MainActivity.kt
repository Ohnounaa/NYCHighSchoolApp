package com.example.nychighschooldata

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.nychighschooldata.ui.main.SectionsPagerAdapter
import com.example.nychighschooldata.databinding.ActivityMainBinding
import com.example.nychighschooldata.ui.main.DetailFragment;
import com.example.nychighschooldata.ui.main.DetailViewModel
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager, lifecycle)
        val viewPager: ViewPager2 = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "NYC High Schools"
                }
                1 -> {
                    tab.text = "My Favorite High Schools"
                }
            }
            viewPager.currentItem = tab.position
        }.attach()


        val detailViewModel: DetailViewModel by lazy {
            ViewModelProvider(this).get(DetailViewModel::class.java)
        }

        detailViewModel.selectedHighSchool.observe(
            this, { createDetailFragment() }
        )
    }
    private fun createDetailFragment() {
        val detailFragment: DetailFragment =
            DetailFragment.newInstance()
        detailFragment.show(
            supportFragmentManager,
            "add_detail_Fragment"
        )
        }
    }

