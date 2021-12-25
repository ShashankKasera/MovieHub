package com.codeinglogs.moviedetails

import androidx.fragment.app.viewModels
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.moviedetails.databinding.FragmentCastBinding
import com.codeinglogs.moviedetails.databinding.FragmentSimilerBinding
import com.codeinglogs.presentation.viewmodel.trendingmovies.TrendingMoviesViewModel


class SimilerFragment : BaseFragment<TrendingMoviesViewModel, FragmentSimilerBinding>() {

    override val mViewModel: TrendingMoviesViewModel by viewModels()

    override fun onBinding() {

    }

    override fun getViewBinding() = FragmentSimilerBinding.inflate(layoutInflater)


}