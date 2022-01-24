package com.codeinglogs.moviehub.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.codeinglogs.moviedetails.ui.fragment.*
import com.codeinglogs.moviehub.fragmant.*
import com.codeinglogs.persondetails.ui.fragmet.PersonPagingFragment
import com.codeinglogs.persondetails.ui.fragmet.PersonPagingFragmentArgs
import com.codeinglogs.presentation.model.movies.movieenum.MovieType
import com.codeinglogs.presentation.model.person.personenum.PersonType
import com.codeinglogs.presentation.model.tvshow.tvshowenum.TvShowType
import com.codeinglogs.tvshowdetail.ui.fragment.tvshow.TvShowPagingFragment
import com.codeinglogs.tvshowdetail.ui.fragment.tvshow.TvShowPagingFragmentArgs

class SearchViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycal:Lifecycle,
    val search:String
):
    FragmentStateAdapter(fragmentManager,lifecycal) {

    override fun getItemCount(): Int {
        return  3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> MoviePagingFragment.newInstance(MoviePagingFragmentArgs(MovieType.SEARCH,"",search).toBundle())
            1 -> TvShowPagingFragment.newInstance(TvShowPagingFragmentArgs(TvShowType.SEARCH,"",search).toBundle())
            2 -> PersonPagingFragment.newInstance(PersonPagingFragmentArgs(PersonType.SEARCH,search).toBundle())
            else -> Fragment()
        }
    }
}