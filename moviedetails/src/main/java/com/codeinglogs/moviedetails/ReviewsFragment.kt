package com.codeinglogs.moviedetails

import androidx.fragment.app.viewModels
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.moviedetails.databinding.FragmentCastBinding
import com.codeinglogs.moviedetails.databinding.FragmentReviewsBinding
import com.codeinglogs.presentation.viewmodel.trendingmovies.TrendingMoviesViewModel


class ReviewsFragment : BaseFragment<TrendingMoviesViewModel, FragmentReviewsBinding>() {

    override val mViewModel: TrendingMoviesViewModel by viewModels()

    override fun onBinding() {

    }

    override fun getViewBinding() = FragmentReviewsBinding.inflate(layoutInflater)


}