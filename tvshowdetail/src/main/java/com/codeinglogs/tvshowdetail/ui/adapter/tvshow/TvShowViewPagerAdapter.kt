package com.codeinglogs.tvshowdetail.ui.adapter.tvshow

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.codeinglogs.presentation.model.movies.movieenum.MovieType
import com.codeinglogs.presentation.model.tvshow.tvshowenum.TvShowType
import com.codeinglogs.tvshowdetail.ui.fragment.tvshow.*

class TvShowViewPagerAdapter(fragmentManager: FragmentManager, lifecycal:Lifecycle):FragmentStateAdapter(fragmentManager,lifecycal) {
    override fun getItemCount(): Int {
        return  4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> TvShowInfoFragment()
            1 -> TvShowCastFragment()
            2 -> TvShowReviewsFragment()
            3 -> TvShowPagingFragment.newInstance(TvShowPagingFragmentArgs(TvShowType.SIMILAR).toBundle())
            else -> Fragment()
        }
    }
}