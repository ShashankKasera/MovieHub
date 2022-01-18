package com.codeinglogs.moviehub.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.codeinglogs.moviedetails.ui.fragment.*
import com.codeinglogs.moviehub.fragmant.MovieMyListFragment
import com.codeinglogs.moviehub.fragmant.TvShowMyListFragment

class MyListViewPagerAdapter(fragmentManager: FragmentManager, lifecycal:Lifecycle):
    FragmentStateAdapter(fragmentManager,lifecycal) {

    override fun getItemCount(): Int {
        return  2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> MovieMyListFragment()
            1 -> TvShowMyListFragment()
            else -> Fragment()
        }
    }
}