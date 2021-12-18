package com.codeinglogs.moviehub.fragmant


import androidx.fragment.app.viewModels
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.moviehub.databinding.FragmentMyListBinding
import com.codeinglogs.presentation.viewmodel.trendingmovies.TrendingMoviesViewModel


class MyListFragment : BaseFragment<TrendingMoviesViewModel, FragmentMyListBinding>(){

    override val mViewModel: TrendingMoviesViewModel by viewModels()


    override fun onBinding() {

    }

    override fun getViewBinding() = FragmentMyListBinding.inflate(layoutInflater)



}