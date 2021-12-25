package com.codeinglogs.moviedetails

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.codeinglogs.moviedetails.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)

        val tabLayout=findViewById<TabLayout>(R.id.tl_movie_det)
        val viewPager2=findViewById<ViewPager2>(R.id.vp2_movie_det)

        val adapter= ViewPagerAdapter(supportFragmentManager,lifecycle)

        viewPager2.adapter=adapter

        TabLayoutMediator(tabLayout, viewPager2){tab,position->
            when(position){
                0-> tab.text="Info"
                1-> tab.text="Cast"
                2-> tab.text="Reviews"
                3-> tab.text="Similer"
            }
        }.attach()
    }

    companion object{
        fun getInstance(context: Context) = Intent(context, TabActivity::class.java)
    }
}