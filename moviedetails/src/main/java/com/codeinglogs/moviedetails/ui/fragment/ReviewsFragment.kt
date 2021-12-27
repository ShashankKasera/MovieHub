package com.codeinglogs.moviedetails.ui.fragment

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.moviedetails.databinding.FragmentCastBinding
import com.codeinglogs.moviedetails.databinding.FragmentReviewsBinding
import com.codeinglogs.moviedetails.ui.adapter.CastAdapter
import com.codeinglogs.moviedetails.ui.adapter.ReviewAdapter
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.moviedetail.MovieDetailViewModel
import com.codeinglogs.presentation.viewmodel.trendingmovies.TrendingMoviesViewModel
import kotlin.math.log


private const val TAG = "123ReviewsFragment"
class ReviewsFragment : BaseFragment<MovieDetailViewModel, FragmentReviewsBinding>() {

    private lateinit var reviewAdapter: ReviewAdapter
    override val mViewModel: MovieDetailViewModel by activityViewModels()

    override fun onBinding() {

        setUpReviewAdapter()

        mViewModel.movieDetails.observe(this){
            it.peekContent().let{it ->
                when(it){
                    is State.Failed -> {
                        Log.i(TAG, "Failed: MovieDetailActivity ${it.message}")
                        showProgressBar(false)
                    }
                    is State.Loading -> {
                        Log.i(TAG, "Loading: MovieDetailActivity ${it.data}")
                        showProgressBar(true)
                    }
                    is State.Success -> {
                        Log.i(TAG, "Success: MovieDetailActivity ${it.data}")

                        showProgressBar(false)
                        Log.i(TAG, "onBinding: ${it.data.movieReviewsResponse.results}")
                        reviewAdapter.submitList(it.data.movieReviewsResponse.results)

                    }
                }
            }
        }
    }

    private fun setUpReviewAdapter() {
        reviewAdapter = ReviewAdapter()
        mViewBinding.rvMovieReview.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        mViewBinding.rvMovieReview.adapter=this.reviewAdapter


    }

    override fun getViewBinding() = FragmentReviewsBinding.inflate(layoutInflater)


}