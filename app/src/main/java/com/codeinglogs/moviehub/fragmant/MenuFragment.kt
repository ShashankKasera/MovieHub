package com.codeinglogs.moviehub.fragmant


import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.moviehub.databinding.FragmentMenuBinding
import com.codeinglogs.presentation.viewmodel.trendingmovies.TrendingMoviesViewModel


class MenuFragment : BaseFragment<TrendingMoviesViewModel, FragmentMenuBinding>(){

    override val mViewModel: TrendingMoviesViewModel by viewModels()

    override fun onBinding() {

    }

    override fun getViewBinding() = FragmentMenuBinding.inflate(layoutInflater)



}