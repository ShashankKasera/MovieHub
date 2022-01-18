package com.codeinglogs.moviehub.activity

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.moviehub.adapter.MoviesPrimaryAdapter
import com.codeinglogs.moviehub.databinding.ActivityTrandingMoviesBinding
import com.codeinglogs.presentation.viewmodel.pagingmovies.MoviesPagingViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "1231viesActivity"

@AndroidEntryPoint
class TrandingMoviesActivity : BaseActivity<MoviesPagingViewModel, ActivityTrandingMoviesBinding>() {

    override val mViewModel: MoviesPagingViewModel by viewModels()
    override fun getViewBinding() = ActivityTrandingMoviesBinding.inflate(layoutInflater)

    //lateinit var adapter: TrendingMoviesAdapter
    lateinit var adapter: MoviesPrimaryAdapter

    override fun onBinding() {

        initProgressBar(mViewBinding.loader)
//        mViewModel.getTrendingMoviesList()
//
//        mViewModel.trendingMoviesList.observe(this){
//            it.contentIfNotHandled?.let{it ->
//                when(it){
//                    is State.Failed -> {
//                        Log.i(TAG, "Failed: ${it.message}")
//                        showProgressBar(false)
//                    }
//                    is State.Loading -> {
//                        Log.i(TAG, "Loading: ${it.data}")
//                        if(it.data!=null&& it.data?.results?.isNotEmpty() == true){
//                            adapter.submitList(it.data?.results)
//                            showProgressBar(false)
//                        }
//                        else{
//                            showProgressBar(true)
//                        }
//
//                    }
//                    is State.Success -> {
//                        Log.i(TAG, "Success: ${it.data}")
//                        lifecycleScope.launch(Dispatchers.Main) {
//                            delay(2000)
//                            showProgressBar(false)
//                            adapter.submitList(it.data.results)
//                        }
//                    }
//                }
//            }
//        }

//        mViewModel.trendingMovies.observe(this){
//            adapter.submitData(lifecycle,it)
//        }


        adapter = MoviesPrimaryAdapter()
        mViewBinding.recyclerView.layoutManager= LinearLayoutManager(this)
        mViewBinding.recyclerView.adapter=this.adapter


//        adapter = TrendingMoviesAdapter()
//        mViewBinding.recyclerView.layoutManager= LinearLayoutManager(this)
//        mViewBinding.recyclerView.adapter=this.adapter.withLoadStateHeaderAndFooter(
//            header = TPWLoadStateAdapter { adapter.retry() },
//            footer = TPWLoadStateAdapter { adapter.retry() },
//        )
//        mViewBinding.buttonRetry.setOnClickListener {
//            adapter.retry()
//        }


//        adapter.addLoadStateListener { loadState ->
//
//            mViewBinding.apply {
//
//                progressBar.isVisible = loadState.source.refresh is LoadState.Loading
//                recyclerView.isVisible = loadState.source.refresh is LoadState.NotLoading
//                buttonRetry.isVisible = loadState.source.refresh is LoadState.Error
//                textViewError.isVisible = loadState.source.refresh is LoadState.Error
//
//                // empty view
//                if (loadState.source.refresh is LoadState.NotLoading &&
//                    loadState.append.endOfPaginationReached &&
//                    adapter.itemCount < 1) {
//                    recyclerView.isVisible = false
//                    textViewEmpty.isVisible = true
//                } else {
//                    textViewEmpty.isVisible = false
//                }
//            }
//        }
    }

    companion object{

        fun getInstance(context: Context) = Intent(context, TrandingMoviesActivity::class.java)

    }
}