package com.codeinglogs.moviehub.activity

import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.moviehub.adapter.TPWLoadStateAdapter
import com.codeinglogs.moviehub.adapter.TrendingMoviesAdapter
import com.codeinglogs.moviehub.databinding.ActivityTrandingMoviesBinding
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.trendingmovies.TrendingMoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrandingMoviesActivity : BaseActivity<TrendingMoviesViewModel, ActivityTrandingMoviesBinding>() {

    override val mViewModel: TrendingMoviesViewModel by viewModels()
    override fun getViewBinding() = ActivityTrandingMoviesBinding.inflate(layoutInflater)

    lateinit var adapter: TrendingMoviesAdapter

    override fun onBinding() {

        mViewModel.getTrendingMoviesList()

        mViewModel.trendingMoviesList.observe(this){
            it.contentIfNotHandled?.let{it ->
                when(it){
                    is State.Failed -> showProgressBar(false)
                    is State.Loading -> showProgressBar(true)
                    is State.Success -> {
                        ///Log.i("fwkjgnkq", "onBinding: ${it.data.results}")
                        showProgressBar(false)
                    }
                }
            }
        }

        mViewModel.trendingMovies.observe(this){
            adapter.submitData(lifecycle,it)
        }


        adapter = TrendingMoviesAdapter()
        mViewBinding.recyclerView.layoutManager= LinearLayoutManager(this)
        mViewBinding.recyclerView.adapter=this.adapter.withLoadStateHeaderAndFooter(
            header = TPWLoadStateAdapter { adapter.retry() },
            footer = TPWLoadStateAdapter { adapter.retry() },
        )
        mViewBinding.buttonRetry.setOnClickListener {
            adapter.retry()
        }


        adapter.addLoadStateListener { loadState ->

            mViewBinding.apply {

                progressBar.isVisible = loadState.source.refresh is LoadState.Loading
                recyclerView.isVisible = loadState.source.refresh is LoadState.NotLoading
                buttonRetry.isVisible = loadState.source.refresh is LoadState.Error
                textViewError.isVisible = loadState.source.refresh is LoadState.Error

                // empty view
                if (loadState.source.refresh is LoadState.NotLoading &&
                    loadState.append.endOfPaginationReached &&
                    adapter.itemCount < 1) {
                    recyclerView.isVisible = false
                    textViewEmpty.isVisible = true
                } else {
                    textViewEmpty.isVisible = false
                }
            }
        }
    }

}