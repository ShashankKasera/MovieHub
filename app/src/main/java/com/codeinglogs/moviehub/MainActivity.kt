package com.codeinglogs.moviehub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.moviehub.databinding.ActivityMainBinding
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.trendingpersonweek.ResultTrendingPersonWeekList
import com.codeinglogs.presentation.model.trendingtvshow.ResultTrendingTvShow
import com.codeinglogs.presentation.viewmodel.personviewmodel.PersonViewModel
import com.codeinglogs.presentation.viewmodel.trendingmovies.TrendingMoviesViewModel
import com.codeinglogs.presentation.viewmodel.trendingpersonweek.TrendingPersonWeekViewModel
import com.codeinglogs.presentation.viewmodel.trendingtvshow.TrendingTvShowViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "123MainActivity"

@AndroidEntryPoint
class MainActivity : BaseActivity<TrendingPersonWeekViewModel, ActivityMainBinding>() {

    override val mViewModel:TrendingPersonWeekViewModel by viewModels()
    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    lateinit var adapter:Adapter

    override fun onBinding() {

        mViewModel.getTrendingPersonWeekList()

        mViewModel.trendingPersonWeekViewModel.observe(this){
            it.contentIfNotHandled?.let{it ->
                when(it){
                    is State.Failed -> showProgressBar(false)
                    is State.Loading -> showProgressBar(true)
                    is State.Success -> {
                        Log.i(TAG, "onBinding: ${it.data.resultTrendingPersonWeekLists}")
                        showProgressBar(false)
                        adapter.submitList(it.data.resultTrendingPersonWeekLists)
                    }
                }
            }
        }



        adapter = Adapter(object : Adapter.Actions{

            override fun onTMovieClick(data: ResultTrendingPersonWeekList) {
                TODO("Not yet implemented")
            }

            override fun onUMovieClick() {

            }
        }) {
            10
        }
        mViewBinding.recyclerView.layoutManager=LinearLayoutManager(this)
        mViewBinding.recyclerView.adapter=this.adapter
        initProgressBar(mViewBinding.loader)

    }

}