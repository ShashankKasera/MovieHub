package com.codeinglogs.moviedetails.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.codeinglogs.moviedetails.ui.fragment.CastFragment
import com.codeinglogs.moviedetails.ui.fragment.InfoFragment
import com.codeinglogs.moviedetails.ui.fragment.ReviewsFragment
import com.codeinglogs.moviedetails.ui.fragment.SimilerFragment

class ViewPagerAdapter( fragmentManager: FragmentManager,lifecycal:Lifecycle):FragmentStateAdapter(fragmentManager,lifecycal) {
    override fun getItemCount(): Int {
        return  4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> InfoFragment()
            1 -> CastFragment()
            2 -> ReviewsFragment()
            3 -> SimilerFragment()
            else -> Fragment()
        }
    }
}