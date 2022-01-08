package com.codeinglogs.tvshowdetail.ui.activity

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.trendingtvshow.TrendingTvShowViewModel
import com.codeinglogs.tvshowdetail.databinding.ActivityTvShowPagingBinding
import com.codeinglogs.tvshowdetail.ui.adapter.tvshow.TvShowLoadStateAdapter
import com.codeinglogs.tvshowdetail.ui.adapter.tvshow.TvShowPagingAdatper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowPagingActivity : BaseActivity<TrendingTvShowViewModel, ActivityTvShowPagingBinding>() {

    lateinit var tvShowPagingAdatper: TvShowPagingAdatper
    override val mViewModel: TrendingTvShowViewModel by viewModels()
    override fun getViewBinding() = ActivityTvShowPagingBinding.inflate(layoutInflater)


    override fun onBinding() {

        mViewModel.getTrendingTvShowList()
        mViewModel.trendingTvShowViewModel.observe(this) {
            it.contentIfNotHandled?.let {
                when (it) {
                    is State.Failed -> showProgressBar(false)
                    is State.Loading -> showProgressBar(true)
                    is State.Success -> {
                        Log.i("fwkjgnkq", "onBinding: ${it.data.results}")
                        showProgressBar(false)
                    }
                }
            }
        }


        mViewModel.trendingTvShow.observe(this) {
            tvShowPagingAdatper.submitData(lifecycle, it)
        }

        tvShowPagingAdatper = TvShowPagingAdatper()
        mViewBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        mViewBinding.recyclerView.adapter = this.tvShowPagingAdatper.withLoadStateHeaderAndFooter(
            header = TvShowLoadStateAdapter { tvShowPagingAdatper.retry() },
            footer = TvShowLoadStateAdapter { tvShowPagingAdatper.retry() },
        )
        mViewBinding.buttonRetry.setOnClickListener {
            tvShowPagingAdatper.retry()
        }


        tvShowPagingAdatper.addLoadStateListener { loadState ->

            mViewBinding.apply {

                progressBar.isVisible = loadState.source.refresh is LoadState.Loading
                recyclerView.isVisible = loadState.source.refresh is LoadState.NotLoading
                buttonRetry.isVisible = loadState.source.refresh is LoadState.Error
                textViewError.isVisible = loadState.source.refresh is LoadState.Error

                // empty view
                if (loadState.source.refresh is LoadState.NotLoading &&
                    loadState.append.endOfPaginationReached &&
                    tvShowPagingAdatper.itemCount < 1
                ) {
                    recyclerView.isVisible = false
                    textViewEmpty.isVisible = true
                } else {
                    textViewEmpty.isVisible = false
                }
            }


        }


    }
    companion object{
        fun getInstance(context: Context) = Intent(context, TvShowPagingActivity::class.java)
    }
}