package com.codeinglogs.moviedetails.ui.fragment

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.moviedetails.databinding.FragmentMovieSimilarBinding
import com.codeinglogs.moviedetails.ui.adapter.MovieSimilarAdapter
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.moviedetail.MovieDetailViewModel

private const val TAG = "123SimilerFragment"

class MovieSimilarFragment : BaseFragment<MovieDetailViewModel, FragmentMovieSimilarBinding>() {

    private lateinit var movieSimilarAdapter: MovieSimilarAdapter

    override val mViewModel: MovieDetailViewModel by activityViewModels()
    override fun getViewBinding() = FragmentMovieSimilarBinding.inflate(layoutInflater)

    override fun onBinding() {
        init()
        movieSimilarObserve()
    }

    private fun movieSimilarObserve() {
        mViewModel.movieDetails.observe(this){
            it.peekContent()?.let{it ->
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

                        setUpSimilarAdapter()
                        movieSimilarAdapter.submitList(it.data.MovieSimilarResponse.results)

                    }
                }
            }
        }
    }

    private fun init() {
        setUpSimilarAdapter()
    }

    private fun setUpSimilarAdapter() {
        movieSimilarAdapter = MovieSimilarAdapter()
        mViewBinding.rvMovieSimiler.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        mViewBinding.rvMovieSimiler.adapter=this.movieSimilarAdapter
    }


}