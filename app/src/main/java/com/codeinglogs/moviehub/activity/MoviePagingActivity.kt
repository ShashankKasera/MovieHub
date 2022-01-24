package com.codeinglogs.moviehub.activity

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.moviehub.adapter.MoviePagingAdapter
import com.codeinglogs.moviehub.adapter.HomeLoadStateAdapter
import com.codeinglogs.moviehub.databinding.ActivityMoviePagingBinding
import com.codeinglogs.presentation.model.movies.movieenum.MovieType
import com.codeinglogs.presentation.viewmodel.pagingmovies.MoviesPagingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviePagingActivity : BaseActivity<MoviesPagingViewModel, ActivityMoviePagingBinding>() {

    override val mViewModel: MoviesPagingViewModel by viewModels()
    override fun getViewBinding() = ActivityMoviePagingBinding.inflate(layoutInflater)

    lateinit var moviePagingAdapter: MoviePagingAdapter

    override fun onBinding() {

        init()

    }

    private fun moviePagingObserve(type: MovieType, movieId: String, movieSearch: String) {

        mViewModel.getMoviesList(type,movieId,movieSearch).observe(this){
            moviePagingAdapter.submitData(lifecycle,it)
        }
    }

    private fun init(){

        val type = intent.getSerializableExtra(TYPE) as MovieType
        val movieId = intent.getStringExtra(MOVIEID) as String
        val movieSearch = intent.getStringExtra(MOVIESEARCH) as String
        Log.i("kfkmlw", "init: $type")
        moviePagingObserve(type,movieId,movieSearch)
        setUpMoviePagingAdapter()
        loadState()
        retry()
    }

    private fun retry() {
        mViewBinding.bRetryMoviePagingHome.setOnClickListener {
            moviePagingAdapter.retry()
        }

    }

    private fun loadState() {
        moviePagingAdapter.addLoadStateListener { loadState ->

            mViewBinding.apply {

                pbMoviePagingHome.isVisible = loadState.source.refresh is LoadState.Loading
                rvMoviePagingHome.isVisible = loadState.source.refresh is LoadState.NotLoading
                bRetryMoviePagingHome.isVisible = loadState.source.refresh is LoadState.Error

                // empty view
                if (loadState.source.refresh is LoadState.NotLoading &&
                    loadState.append.endOfPaginationReached &&
                    moviePagingAdapter.itemCount < 1) {
                    rvMoviePagingHome.isVisible = false
                }
            }
        }
    }

    private fun setUpMoviePagingAdapter() {
        moviePagingAdapter = MoviePagingAdapter()
        mViewBinding.rvMoviePagingHome.layoutManager= LinearLayoutManager(this)
        mViewBinding.rvMoviePagingHome.adapter=this.moviePagingAdapter.withLoadStateHeaderAndFooter(
            header = HomeLoadStateAdapter { moviePagingAdapter.retry() },
            footer = HomeLoadStateAdapter { moviePagingAdapter.retry() },
        )
    }


    companion object{

        const val TYPE = "type"
        const val MOVIEID = "movieId"
        const val MOVIESEARCH = "movieSearch"

        fun getInstance(context: Context,type : MovieType,movieId:String = "",movieSearch:String = "") = Intent(context, MoviePagingActivity::class.java).apply {
            putExtra(TYPE,type)
            putExtra(MOVIEID,movieId)
            putExtra(MOVIESEARCH,movieSearch)
        }


    }

}