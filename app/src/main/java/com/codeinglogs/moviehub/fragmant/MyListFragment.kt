package com.codeinglogs.moviehub.fragmant


import androidx.fragment.app.viewModels
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.moviehub.adapter.MyListViewPagerAdapter
import com.codeinglogs.moviehub.databinding.FragmentMyListBinding
import com.codeinglogs.presentation.viewmodel.pagingmovies.MoviesPagingViewModel
import com.google.android.material.tabs.TabLayoutMediator


class MyListFragment : BaseFragment<MoviesPagingViewModel, FragmentMyListBinding>(){

    lateinit var myListViewPagerAdapter: MyListViewPagerAdapter

    override val mViewModel: MoviesPagingViewModel by viewModels()
    override fun getViewBinding() = FragmentMyListBinding.inflate(layoutInflater)

    override fun onBinding() {

        setUpTabLayout()

    }


    private fun setUpTabLayout(){

        myListViewPagerAdapter= MyListViewPagerAdapter(getParentFragmentManager() ,lifecycle)
        mViewBinding.vp2MyList.adapter=myListViewPagerAdapter
        TabLayoutMediator(mViewBinding.tlMyList, mViewBinding.vp2MyList){tab,position->
            when(position){
                0-> tab.text="Movie"
                1-> tab.text="Tv Show"
            }
        }.attach()
    }

}