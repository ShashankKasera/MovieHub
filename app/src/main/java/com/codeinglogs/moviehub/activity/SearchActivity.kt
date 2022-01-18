package com.codeinglogs.moviehub.activity

import androidx.activity.viewModels
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.moviehub.adapter.SearchViewPagerAdapter
import com.codeinglogs.moviehub.databinding.ActivitySearchBinding
import com.codeinglogs.presentation.viewmodel.pagingmovies.MoviesPagingViewModel
import com.google.android.material.tabs.TabLayoutMediator

class SearchActivity : BaseActivity<MoviesPagingViewModel, ActivitySearchBinding>(){

    lateinit var searchViewPagerAdapter: SearchViewPagerAdapter

    override val mViewModel: MoviesPagingViewModel by viewModels()
    override fun getViewBinding() = ActivitySearchBinding.inflate(layoutInflater)

    override fun onBinding() {

        setUpTabLayout()
    }
    private fun setUpTabLayout(){

        searchViewPagerAdapter= SearchViewPagerAdapter(supportFragmentManager ,lifecycle)
        mViewBinding.vp2Search.adapter=searchViewPagerAdapter
        TabLayoutMediator(mViewBinding.tlSearch, mViewBinding.vp2Search){tab,position->
            when(position){
                0-> tab.text="Movie"
                1-> tab.text="Tv Show"
                2-> tab.text="Person"

            }
        }.attach()
    }

}