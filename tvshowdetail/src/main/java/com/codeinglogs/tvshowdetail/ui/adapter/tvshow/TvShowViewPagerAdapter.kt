package com.codeinglogs.tvshowdetail.ui.adapter.tvshow

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.codeinglogs.tvshowdetail.ui.fragment.tvshow.TvShowCastFragment
import com.codeinglogs.tvshowdetail.ui.fragment.tvshow.TvShowInfoFragment
import com.codeinglogs.tvshowdetail.ui.fragment.tvshowseason.TvShowReviewsFragment
import com.codeinglogs.tvshowdetail.ui.fragment.tvshow.TvShowSimilarFragment

class TvShowViewPagerAdapter(fragmentManager: FragmentManager, lifecycal:Lifecycle):FragmentStateAdapter(fragmentManager,lifecycal) {
    override fun getItemCount(): Int {
        return  4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> TvShowInfoFragment()
            1 -> TvShowCastFragment()
            2 -> TvShowReviewsFragment()
            3 -> TvShowSimilarFragment()
            else -> Fragment()
        }
    }
}