package com.codeinglogs.moviedetails.ui.activity

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.moviedetails.databinding.ActivityMovieCrewBinding
import com.codeinglogs.moviedetails.ui.adapter.MovieAllCrewAdapter
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.moviedetail.MovieDetailViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieCrewActivity : BaseActivity<MovieDetailViewModel, ActivityMovieCrewBinding>()  {


    private lateinit var movieAllCrewAdapter: MovieAllCrewAdapter

    override val mViewModel: MovieDetailViewModel by viewModels()

    override fun getViewBinding()= ActivityMovieCrewBinding.inflate(layoutInflater)

    override fun onBinding() {
        init()
        movieInfoObserve()
    }

    private fun init() {

        mViewBinding.tbMovieCrew.setTitle("Crew")

        val movieId = intent.getStringExtra(MOVIE_ID)

        movieId?.let {
            mViewModel.getMovieDetails(it)
        }
        setUpAllCrewAdapter()

    }

    private fun setUpAllCrewAdapter() {
        movieAllCrewAdapter = MovieAllCrewAdapter()
        mViewBinding.rvMovieCrew.layoutManager= LinearLayoutManager(this,)
        mViewBinding.rvMovieCrew.adapter=this.movieAllCrewAdapter
    }

    private fun movieInfoObserve(){
        mViewModel.movieDetails.observe(this){
            it.peekContent()?.let{it ->
                when(it){
                    is State.Failed -> {
                        Log.i("jknck", "Failed: MovieDetailActivity ${it.message}")
                        showProgressBar(false)
                    }
                    is State.Loading -> {
                        Log.i("jknck", "Loading: MovieDetailActivity ${it.data}")
                        showProgressBar(true)
                    }
                    is State.Success -> {
                        Log.i("jknck", "Success: MovieDetailActivity ${it.data}")

                        showProgressBar(false)

                        movieAllCrewAdapter.submitList(it.data.movieCreditsResponse.crew)

                    }
                }
            }
        }
    }

    companion object{
        const val MOVIE_ID = "movieId"

        fun getInstance(context: Context,movieId : String) = Intent(context, MovieCrewActivity::class.java)
            .apply {
                putExtra(MOVIE_ID,movieId)
            }

    }
}