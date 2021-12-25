package com.codeinglogs.moviedetails

import androidx.fragment.app.viewModels
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.moviedetails.databinding.FragmentCastBinding
import com.codeinglogs.presentation.viewmodel.trendingmovies.TrendingMoviesViewModel


class CastFragment : BaseFragment<TrendingMoviesViewModel, FragmentCastBinding>() {

    override val mViewModel: TrendingMoviesViewModel by viewModels()

    override fun onBinding() {

    }

    override fun getViewBinding() = FragmentCastBinding.inflate(layoutInflater)


}