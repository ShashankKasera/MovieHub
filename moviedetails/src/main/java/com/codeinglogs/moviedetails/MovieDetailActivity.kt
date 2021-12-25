package com.codeinglogs.moviedetails

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.viewModels
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.moviedetails.adapter.ViewPagerAdapter
import com.codeinglogs.moviedetails.databinding.ActivityMovieDetailBinding
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.moviedetail.MovieDetailViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "123MovieDetailActivity"

@AndroidEntryPoint
class MovieDetailActivity : BaseActivity<MovieDetailViewModel, ActivityMovieDetailBinding>() {

    lateinit var adapter:ViewPagerAdapter
    override val mViewModel: MovieDetailViewModel by viewModels()

    override fun getViewBinding()= ActivityMovieDetailBinding.inflate(layoutInflater)

    override fun onBinding() {

        mViewBinding.toolbar.setTitle("toolbar Title")
        mViewBinding.collapsingToolbar.setTitle("collapsing")

        adapter=ViewPagerAdapter(supportFragmentManager,lifecycle)

        mViewBinding.vp2MovieDet.adapter=adapter

        TabLayoutMediator(mViewBinding.tlMovieDet, mViewBinding.vp2MovieDet){tab,position->
            when(position){
                0-> tab.text="Info"
                1-> tab.text="Cast"
                2-> tab.text="Reviews"
                3-> tab.text="Similer"
            }
        }.attach()

        mViewModel.getMovieDetails("460458")

        mViewModel.movieDetails.observe(this){
            it.contentIfNotHandled?.let{it ->
                when(it){
                    is State.Failed -> {
                        Log.i(TAG, "Failed: MovieDetailActivity ${it.message}")
                        showProgressBar(false)
                    }
                    is State.Loading -> {
                        Log.i(TAG, "Loading: MovieDetailActivity ${it.data}")
                        showProgressBar(true)
                    }
                    is State.Success -> {
                        Log.i(TAG, "Success: MovieDetailActivity ${it.data}")
                        showProgressBar(false)
                    }
                }
            }
        }
    }


    companion object{
        fun getInstance(context: Context) = Intent(context, MovieDetailActivity::class.java)
    }

}