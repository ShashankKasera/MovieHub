package com.codeinglogs.moviedetails.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.codeinglogs.moviedetails.ui.fragment.*

class MovieViewPagerAdapter(fragmentManager: FragmentManager, lifecycal:Lifecycle):
    FragmentStateAdapter(fragmentManager,lifecycal) {

    override fun getItemCount(): Int {
        return  4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> MovieInfoFragment()
            1 -> MovieCastFragment()
            2 -> MovieReviewsFragment()
            3 -> MovieSimilarFragment()
            else -> Fragment()
        }
    }
}