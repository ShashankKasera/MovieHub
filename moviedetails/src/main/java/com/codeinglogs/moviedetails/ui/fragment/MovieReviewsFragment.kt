package com.codeinglogs.moviedetails.ui.fragment

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.moviedetails.databinding.FragmentMovieReviewsBinding
import com.codeinglogs.moviedetails.ui.adapter.MovieReviewAdapter
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.moviedetail.MovieDetailViewModel


private const val TAG = "123ReviewsFragment"
class MovieReviewsFragment : BaseFragment<MovieDetailViewModel,FragmentMovieReviewsBinding>() {

    private lateinit var movieReviewAdapter: MovieReviewAdapter

    override val mViewModel: MovieDetailViewModel by activityViewModels()
    override fun getViewBinding() = FragmentMovieReviewsBinding.inflate(layoutInflater)

    override fun onBinding() {

        init()
        movieReviewsObserve()
    }

    private fun init() {
        setUpReviewAdapter()
    }

    private fun movieReviewsObserve() {
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
                        movieReviewAdapter.submitList(it.data.movieReviewsResponse.results)

                    }
                }
            }
        }
    }

    private fun setUpReviewAdapter() {
        movieReviewAdapter = MovieReviewAdapter()
        mViewBinding.rvMovieReview.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        mViewBinding.rvMovieReview.adapter=this.movieReviewAdapter

    }


}