package com.codeinglogs.tvshowdetail.ui.adapter.tvshowseason

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.codeinglogs.tvshowdetail.ui.fragment.tvshowseason.TvShowSeasonCastFragment
import com.codeinglogs.tvshowdetail.ui.fragment.tvshowseason.TvShowSeasonEpisodeFragment
import com.codeinglogs.tvshowdetail.ui.fragment.tvshowseason.TvShowSeasonInfoFragment

class TvShowSeasonViewPagerAdapter(fragmentManager: FragmentManager, lifecycal:Lifecycle):FragmentStateAdapter(fragmentManager,lifecycal) {
    override fun getItemCount(): Int {
        return  3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> TvShowSeasonInfoFragment()
            1 -> TvShowSeasonEpisodeFragment()
            2 -> TvShowSeasonCastFragment()
            else -> Fragment()
        }
    }
}