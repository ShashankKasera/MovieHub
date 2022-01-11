package com.codeinglogs.moviedetails.ui.fragment

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.moviedetails.ui.adapter.MovieCastAdapter
import com.codeinglogs.moviedetails.databinding.FragmentMovieCastBinding
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.moviedetail.MovieDetailViewModel

private const val TAG = "123CastFragment"

class MovieCastFragment : BaseFragment<MovieDetailViewModel, FragmentMovieCastBinding>() {

    private lateinit var movieCastAdapter: MovieCastAdapter

    override val mViewModel: MovieDetailViewModel by activityViewModels()
    override fun getViewBinding() = FragmentMovieCastBinding.inflate(layoutInflater)


    override fun onBinding() {

        init()
        movieCastObserve()
    }

    private fun init() {
        setUpCastAdapter()
    }

    private fun movieCastObserve(){

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

                        movieCastAdapter.submitList(it.data.movieCreditsResponse.cast)

                    }
                }
            }
        }
    }
    private fun setUpCastAdapter() {
        movieCastAdapter = MovieCastAdapter()
        mViewBinding.rvMovieCast.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        mViewBinding.rvMovieCast.adapter=this.movieCastAdapter


    }

}