package com.codeinglogs.moviedetails.ui.fragment

import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.moviedetails.databinding.ActivityMoviesPagingBinding
import com.codeinglogs.moviedetails.databinding.FragmentMovieSimilarBinding
import com.codeinglogs.moviedetails.ui.activity.MoviesPagingActivity
import com.codeinglogs.moviedetails.ui.adapter.MovieSimilarAdapter
import com.codeinglogs.moviedetails.ui.adapter.MoviesPagingAdapter
import com.codeinglogs.moviedetails.ui.adapter.MoviesPagingLoadStateAdapter
import com.codeinglogs.moviedetails.ui.adapter.MoviesSimilarPagingAdapter
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.movies.movieenum.MovieType
import com.codeinglogs.presentation.viewmodel.moviedetail.MovieDetailViewModel
import com.codeinglogs.presentation.viewmodel.pagingmovies.MoviesPagingViewModel
import dagger.hilt.android.AndroidEntryPoint


private const val TAG = "123SimilerFragment"
@AndroidEntryPoint
class MovieSimilarFragment : BaseFragment<MoviesPagingViewModel, FragmentMovieSimilarBinding>() {

    lateinit var moviesPagingAdapter: MoviesSimilarPagingAdapter

    override val mViewModel: MoviesPagingViewModel by viewModels()
    override fun getViewBinding() = FragmentMovieSimilarBinding.inflate(layoutInflater)



    override fun onBinding() {

        init()

        pagingLoadState()
        buttonRetry()
    }

    private fun init(){

        moviesObserve()
        setUpTrendingMoviesAdapter()
    }

    private fun moviesObserve() {

        mViewModel.getMoviesList(MovieType.POPULAR).observe(this){
            moviesPagingAdapter.submitData(lifecycle,it)
        }
    }

    private fun setUpTrendingMoviesAdapter(){
        moviesPagingAdapter = MoviesSimilarPagingAdapter()
        mViewBinding.rvMovieSimiler.layoutManager= LinearLayoutManager(requireContext())
        mViewBinding.rvMovieSimiler.adapter=this.moviesPagingAdapter.withLoadStateHeaderAndFooter(
            header = MoviesPagingLoadStateAdapter { moviesPagingAdapter.retry() },
            footer = MoviesPagingLoadStateAdapter { moviesPagingAdapter.retry() },
        )
    }

    private fun pagingLoadState(){

        moviesPagingAdapter.addLoadStateListener { loadState ->

            mViewBinding.apply {

                progressBar.isVisible = loadState.source.refresh is LoadState.Loading
                rvMovieSimiler.isVisible = loadState.source.refresh is LoadState.NotLoading
                buttonRetry.isVisible = loadState.source.refresh is LoadState.Error
                textViewError.isVisible = loadState.source.refresh is LoadState.Error

                // empty view
                if (loadState.source.refresh is LoadState.NotLoading &&
                    loadState.append.endOfPaginationReached &&
                    moviesPagingAdapter.itemCount < 1) {
                    rvMovieSimiler.isVisible = false
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

}