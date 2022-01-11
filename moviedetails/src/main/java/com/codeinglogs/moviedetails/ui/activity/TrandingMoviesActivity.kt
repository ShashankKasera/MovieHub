package com.codeinglogs.moviedetails.ui.activity

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.moviedetails.databinding.ActivityTrandingMoviesBinding
import com.codeinglogs.moviedetails.ui.adapter.TrendingMoviesAdapter
import com.codeinglogs.moviedetails.ui.adapter.TrendingMoviesLoadStateAdapter
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.trendingmovies.TrendingMoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "1231viesActivity"

@AndroidEntryPoint
class TrandingMoviesActivity : BaseActivity<TrendingMoviesViewModel, ActivityTrandingMoviesBinding>() {

    lateinit var trendingMoviesAdapter: TrendingMoviesAdapter

    override val mViewModel: TrendingMoviesViewModel by viewModels()
    override fun getViewBinding() = ActivityTrandingMoviesBinding.inflate(layoutInflater)



    override fun onBinding() {

        init()
        trendingMoviesObserve()
        pagingLoadState()
        buttonRetry()
    }

    private fun init(){
        mViewModel.getTrendingMoviesList()
        setUpTrendingMoviesAdapter()
    }

    private fun trendingMoviesObserve(){

        mViewModel.trendingMoviesList.observe(this){
            it.contentIfNotHandled?.let{it ->
                when(it){
                    is State.Failed -> showProgressBar(false)
                    is State.Loading -> showProgressBar(true)
                    is State.Success -> {
                        Log.i("fwkjgnkq", "onBinding: ${it.data.results}")
                        showProgressBar(false)
                    }
                }
            }
        }

        mViewModel.trendingMovies.observe(this){
            trendingMoviesAdapter.submitData(lifecycle,it)
        }
    }

    private fun setUpTrendingMoviesAdapter(){
        trendingMoviesAdapter = TrendingMoviesAdapter()
        mViewBinding.recyclerView.layoutManager= LinearLayoutManager(this)
        mViewBinding.recyclerView.adapter=this.trendingMoviesAdapter.withLoadStateHeaderAndFooter(
            header = TrendingMoviesLoadStateAdapter { trendingMoviesAdapter.retry() },
            footer = TrendingMoviesLoadStateAdapter { trendingMoviesAdapter.retry() },
        )
    }

    private fun pagingLoadState(){

        trendingMoviesAdapter.addLoadStateListener { loadState ->

            mViewBinding.apply {

                progressBar.isVisible = loadState.source.refresh is LoadState.Loading
                recyclerView.isVisible = loadState.source.refresh is LoadState.NotLoading
                buttonRetry.isVisible = loadState.source.refresh is LoadState.Error
                textViewError.isVisible = loadState.source.refresh is LoadState.Error

                // empty view
                if (loadState.source.refresh is LoadState.NotLoading &&
                    loadState.append.endOfPaginationReached &&
                    trendingMoviesAdapter.itemCount < 1) {
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
            trendingMoviesAdapter.retry()
        }
    }

    companion object{
        fun getInstance(context: Context) = Intent(context, TrandingMoviesActivity::class.java)
    }
}