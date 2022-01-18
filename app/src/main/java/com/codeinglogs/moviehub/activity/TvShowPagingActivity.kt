package com.codeinglogs.moviehub.activity

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.moviehub.adapter.HomeLoadStateAdapter
import com.codeinglogs.moviehub.adapter.TvShowPagingAdapter
import com.codeinglogs.moviehub.databinding.ActivityTvShowPagingBinding
import com.codeinglogs.presentation.model.tvshow.tvshowenum.TvShowType
import com.codeinglogs.presentation.viewmodel.pagingtvshow.TvShowPagingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowPagingActivity : BaseActivity<TvShowPagingViewModel, ActivityTvShowPagingBinding>() {

    override val mViewModel: TvShowPagingViewModel by viewModels()
    override fun getViewBinding() = ActivityTvShowPagingBinding.inflate(layoutInflater)

    lateinit var tvShowPagingAdapter: TvShowPagingAdapter

    override fun onBinding() {

        init()

        val type = intent.getSerializableExtra(TYPE) as TvShowType
        tvShowPagingObserve(type)
    }

    private fun tvShowPagingObserve(type: TvShowType) {


        mViewModel.getTvShowList(type).observe(this){
            tvShowPagingAdapter.submitData(lifecycle,it)
        }
    }

    private fun init(){

        setUpMoviePagingAdapter()
        loadState()
        retry()
    }

    private fun retry() {
        mViewBinding.bRetryTvShowPagingHome.setOnClickListener {
            tvShowPagingAdapter.retry()
        }

    }

    private fun loadState() {
        tvShowPagingAdapter.addLoadStateListener { loadState ->

            mViewBinding.apply {

                pbTvShowPagingHome.isVisible = loadState.source.refresh is LoadState.Loading
                rvTvShowPagingHome.isVisible = loadState.source.refresh is LoadState.NotLoading
                bRetryTvShowPagingHome.isVisible = loadState.source.refresh is LoadState.Error

                // empty view
                if (loadState.source.refresh is LoadState.NotLoading &&
                    loadState.append.endOfPaginationReached &&
                    tvShowPagingAdapter.itemCount < 1) {
                    rvTvShowPagingHome.isVisible = false
                }
            }
        }
    }

    private fun setUpMoviePagingAdapter() {
        tvShowPagingAdapter = TvShowPagingAdapter()
        mViewBinding.rvTvShowPagingHome.layoutManager= LinearLayoutManager(this)
        mViewBinding.rvTvShowPagingHome.adapter=this.tvShowPagingAdapter.withLoadStateHeaderAndFooter(
            header = HomeLoadStateAdapter { tvShowPagingAdapter.retry() },
            footer = HomeLoadStateAdapter { tvShowPagingAdapter.retry() },
        )
    }


    companion object{
        const val TYPE = "type"

        fun getInstance(context: Context,type : TvShowType) = Intent(context, TvShowPagingActivity::class.java).apply {
            putExtra(TYPE,type)
        }

    }

}