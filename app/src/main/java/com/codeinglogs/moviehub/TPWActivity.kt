package com.codeinglogs.moviehub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.moviehub.databinding.ActivityMainBinding
import com.codeinglogs.moviehub.databinding.ActivityTpwBinding
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.trendingpersonweek.ResultTrendingPersonWeekList
import com.codeinglogs.presentation.viewmodel.trendingpersonweek.TrendingPersonWeekViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TPWActivity : BaseActivity<TrendingPersonWeekViewModel, ActivityTpwBinding>() {

    override val mViewModel: TrendingPersonWeekViewModel by viewModels()
    override fun getViewBinding() = ActivityTpwBinding.inflate(layoutInflater)

    lateinit var adapter:TPWAdapter

    override fun onBinding() {

        mViewModel.getTrendingPersonWeekList()

        mViewModel.trendingPersonWeekViewModel.observe(this){
            it.contentIfNotHandled?.let{it ->
                when(it){
                    is State.Failed -> showProgressBar(false)
                    is State.Loading -> showProgressBar(true)
                    is State.Success -> {
                        Log.i("fwkjgnkq", "onBinding: ${it.data.resultTrendingPersonWeekLists}")
                        showProgressBar(false)
                    }
                }
            }
        }

        mViewModel.trendingPersonWeekPaging.observe(this){
            adapter.submitData(lifecycle,it)
        }


        adapter = TPWAdapter()
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