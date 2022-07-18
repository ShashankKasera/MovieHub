package com.codeinglogs.moviedetails.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.moviedetails.databinding.FragmentMoviePagingBinding
import com.codeinglogs.moviedetails.ui.adapter.MoviesPagingAdapter
import com.codeinglogs.moviedetails.ui.adapter.MoviesPagingLoadStateAdapter
import com.codeinglogs.presentation.model.movies.movieenum.MovieType
import com.codeinglogs.presentation.viewmodel.pagingmovies.MoviesPagingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviePagingFragment: BaseFragment<MoviesPagingViewModel, FragmentMoviePagingBinding>() {

    private lateinit var moviesPagingAdapter: MoviesPagingAdapter
    private val args: MoviePagingFragmentArgs by navArgs()

    override val mViewModel: MoviesPagingViewModel by viewModels()
    override fun getViewBinding() = FragmentMoviePagingBinding.inflate(layoutInflater)

    override fun onBinding() {
        init()
        buttonRetry()
        pagingLoadState()
    }

    private fun init(){
        val type = args.movieType
        val id = args.id
        val movieSearch = args.movieSearch
        Log.i("dscnsbdcb", "init: $type")
        setUpMoviePagingAdapter()
        moviePagingObserve(type,id,movieSearch)
    }

    private fun setUpMoviePagingAdapter(){
        moviesPagingAdapter = MoviesPagingAdapter()
        mViewBinding.rvMoviePaging.layoutManager = LinearLayoutManager(context)
        mViewBinding.rvMoviePaging.adapter = this.moviesPagingAdapter.withLoadStateHeaderAndFooter(
            header = MoviesPagingLoadStateAdapter { moviesPagingAdapter.retry() },
            footer = MoviesPagingLoadStateAdapter { moviesPagingAdapter.retry() },
        )
    }

    private fun moviePagingObserve(type: MovieType, id: String, movieSearch: String) {
        mViewModel.getMoviesList(type,id,movieSearch).observe(this) {
            Log.i("mknekb", "moviePagingObserve: $it")
            moviesPagingAdapter.submitData(lifecycle, it)
        }
    }

    private fun buttonRetry(){
        mViewBinding.bRetryMoviePaging.setOnClickListener {
            moviesPagingAdapter.retry()
        }
    }

    private fun pagingLoadState(){
        moviesPagingAdapter.addLoadStateListener { loadState ->

            mViewBinding.apply {
                pbMoviePaging.isVisible = loadState.source.refresh is LoadState.Loading
                rvMoviePaging.isVisible = loadState.source.refresh is LoadState.NotLoading
                bRetryMoviePaging.isVisible = loadState.source.refresh is LoadState.Error
                tvErrorMoviePaging.isVisible = loadState.source.refresh is LoadState.Error

                // empty view
                if (loadState.source.refresh is LoadState.NotLoading &&
                    loadState.append.endOfPaginationReached &&
                    moviesPagingAdapter.itemCount < 1
                ) {
                    rvMoviePaging.isVisible = false
                    tvErrorMoviePaging.isVisible = true
                } else {
                    tvErrorMoviePaging.isVisible = false
                }
            }
        }
    }


    companion object {
        fun newInstance(bundle: Bundle): MoviePagingFragment {
            val fragment = MoviePagingFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}