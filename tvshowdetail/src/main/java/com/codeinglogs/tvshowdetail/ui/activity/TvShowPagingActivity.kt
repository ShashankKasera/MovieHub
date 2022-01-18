package com.codeinglogs.tvshowdetail.ui.activity

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.presentation.model.tvshow.tvshowenum.TvShowType
import com.codeinglogs.presentation.viewmodel.pagingtvshow.TvShowPagingViewModel
import com.codeinglogs.tvshowdetail.databinding.ActivityTvShowPagingBinding
import com.codeinglogs.tvshowdetail.ui.adapter.tvshow.TvShowLoadStateAdapter
import com.codeinglogs.tvshowdetail.ui.adapter.tvshow.TvShowPagingAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowPagingActivity : BaseActivity<TvShowPagingViewModel, ActivityTvShowPagingBinding>() {

    lateinit var tvShowPagingAdapter: TvShowPagingAdapter

    override val mViewModel: TvShowPagingViewModel by viewModels()
    override fun getViewBinding() = ActivityTvShowPagingBinding.inflate(layoutInflater)

    override fun onBinding() {

        init()
        buttonRetry()
        pagingLoadState()
    }

    private fun init(){
        val type = intent.getSerializableExtra(TYPE) as TvShowType
        Log.i("kjkk", "init: $type")
        setUpTvShowPagingAdapter()
        TvShowPagingObserve(type)
    }

    private fun setUpTvShowPagingAdapter(){
        tvShowPagingAdapter = TvShowPagingAdapter()
        mViewBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        mViewBinding.recyclerView.adapter = this.tvShowPagingAdapter.withLoadStateHeaderAndFooter(
            header = TvShowLoadStateAdapter { tvShowPagingAdapter.retry() },
            footer = TvShowLoadStateAdapter { tvShowPagingAdapter.retry() },
        )
    }

    private fun TvShowPagingObserve(type: TvShowType) {


        mViewModel.getTvShowList(type).observe(this) {
            tvShowPagingAdapter.submitData(lifecycle, it)
        }
    }

    private fun buttonRetry(){
        mViewBinding.buttonRetry.setOnClickListener {
            tvShowPagingAdapter.retry()
        }
    }

    private fun pagingLoadState(){
        tvShowPagingAdapter.addLoadStateListener { loadState ->

            mViewBinding.apply {

                progressBar.isVisible = loadState.source.refresh is LoadState.Loading
                recyclerView.isVisible = loadState.source.refresh is LoadState.NotLoading
                buttonRetry.isVisible = loadState.source.refresh is LoadState.Error
                textViewError.isVisible = loadState.source.refresh is LoadState.Error

                // empty view
                if (loadState.source.refresh is LoadState.NotLoading &&
                    loadState.append.endOfPaginationReached &&
                    tvShowPagingAdapter.itemCount < 1
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
        const val TYPE = "type"

        fun getInstance(context: Context,type : TvShowType) = Intent(context, TvShowPagingActivity::class.java).apply {
            putExtra(TYPE,type)
        }
    }
}