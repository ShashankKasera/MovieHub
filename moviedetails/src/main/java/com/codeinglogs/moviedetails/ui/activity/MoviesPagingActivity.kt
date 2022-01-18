package com.codeinglogs.moviedetails.ui.activity

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.moviedetails.databinding.ActivityMoviesPagingBinding
import com.codeinglogs.moviedetails.ui.adapter.MoviesPagingAdapter
import com.codeinglogs.moviedetails.ui.adapter.MoviesPagingLoadStateAdapter
import com.codeinglogs.presentation.model.movies.movieenum.MovieType
import com.codeinglogs.presentation.viewmodel.pagingmovies.MoviesPagingViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "1231viesActivity"

@AndroidEntryPoint
class MoviesPagingActivity : BaseActivity<MoviesPagingViewModel, ActivityMoviesPagingBinding>() {

    lateinit var moviesPagingAdapter: MoviesPagingAdapter

    override val mViewModel: MoviesPagingViewModel by viewModels()
    override fun getViewBinding() = ActivityMoviesPagingBinding.inflate(layoutInflater)



    override fun onBinding() {

        init()

        pagingLoadState()
        buttonRetry()
    }

    private fun init(){
        val type = intent.getSerializableExtra(TYPE) as MovieType
        Log.i(TAG, "init: $type")
        moviesObserve(type)
        setUpTrendingMoviesAdapter()
    }

    private fun moviesObserve(type: MovieType) {

        mViewModel.getMoviesList(type).observe(this){
            moviesPagingAdapter.submitData(lifecycle,it)
        }
    }

    private fun setUpTrendingMoviesAdapter(){
        moviesPagingAdapter = MoviesPagingAdapter()
        mViewBinding.recyclerView.layoutManager= LinearLayoutManager(this)
        mViewBinding.recyclerView.adapter=this.moviesPagingAdapter.withLoadStateHeaderAndFooter(
            header = MoviesPagingLoadStateAdapter { moviesPagingAdapter.retry() },
            footer = MoviesPagingLoadStateAdapter { moviesPagingAdapter.retry() },
        )
    }

    private fun pagingLoadState(){

        moviesPagingAdapter.addLoadStateListener { loadState ->

            mViewBinding.apply {

                progressBar.isVisible = loadState.source.refresh is LoadState.Loading
                recyclerView.isVisible = loadState.source.refresh is LoadState.NotLoading
                buttonRetry.isVisible = loadState.source.refresh is LoadState.Error
                textViewError.isVisible = loadState.source.refresh is LoadState.Error

                // empty view
                if (loadState.source.refresh is LoadState.NotLoading &&
                    loadState.append.endOfPaginationReached &&
                    moviesPagingAdapter.itemCount < 1) {
                    recyclerView.isVisible = false
                    textViewEmpty.isVisible = true
                } else {
                    textViewEmpty.isVisible = false
                }
            }
        }
    }

    private fun buttonRetry(){
        mViewBinding.buttonRetry.setOnClickListener {
            moviesPagingAdapter.retry()
        }
    }

    companion object{
        const val TYPE = "type"

        fun getInstance(context: Context,type : MovieType) = Intent(context, MoviesPagingActivity::class.java).apply {
            putExtra(TYPE,type)
        }
    }


}