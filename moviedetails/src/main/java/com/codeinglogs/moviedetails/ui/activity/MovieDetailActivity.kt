package com.codeinglogs.moviedetails.ui.activity

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.viewModels
import com.codeinglogs.core.util.PicassoImageLoadingService
import com.codeinglogs.core.util.SliderAdapter
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.moviedetails.ui.adapter.MovieViewPagerAdapter
import com.codeinglogs.moviedetails.databinding.ActivityMovieDetailBinding
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_YOUTUBE
import com.codeinglogs.moviehub.constant.IMAGE_back_YOUTUBE
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.movies.moviedetail.videos.MovieVideo
import com.codeinglogs.presentation.model.movies.moviedetail.videos.MovieVideosResponse
import com.codeinglogs.presentation.viewmodel.moviedetail.MovieDetailViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import ss.com.bannerslider.Slider

private const val TAG = "123MovieDetailActivity"

@AndroidEntryPoint
class MovieDetailActivity : BaseActivity<MovieDetailViewModel, ActivityMovieDetailBinding>() {

    lateinit var adapterMovie:MovieViewPagerAdapter
    override val mViewModel: MovieDetailViewModel by viewModels()

    override fun getViewBinding()= ActivityMovieDetailBinding.inflate(layoutInflater)

    override fun onBinding() {
        init()
        movieDetailObserve()
    }

    private fun movieDetailObserve() {
        mViewModel.movieDetails.observe(this){ it ->
            it.contentIfNotHandled?.let{it ->
                when(it){
                    is State.Failed -> {
                        Log.i(TAG, "Failed: MovieDetailActivity ${it.message}")
                        showProgressBar(false)
                    }
                    is State.Loading -> {
                        Log.i(TAG, "Loading: MovieDetailActivity ${it.data}")

                        it.data?.let {
                            showProgressBar(false)
                            addSlider(mViewBinding.bsMovieMovieDet,it.MovieVideosResponse.results)
                        }?: run {
                            showProgressBar(true)
                        }

                    }
                    is State.Success -> {
                        Log.i(TAG, "Success: MovieDetailActivity ${it.data}")
                        showProgressBar(false)
                        addSlider(mViewBinding.bsMovieMovieDet,it.data.MovieVideosResponse.results)
                    }
                }
            }
        }
    }

    private fun init(){
        setUpToolbar()
        val movieId = intent.getStringExtra(MOVIE_ID)

        Log.i(TAG, "init: "+movieId)

        movieId?.let {
            mViewModel.movieId=it
            mViewModel.getMovieDetails(it)
            setUpTabLayout(movieId)
        }

    }

    private  fun addSlider (slider: Slider, results: List<MovieVideo>, ) {


        val list = ArrayList<String>()
        for (result in results)
            list.add(IMAGE_BASE_URL_YOUTUBE +result.key+IMAGE_back_YOUTUBE)

        Slider.init(PicassoImageLoadingService());
        slider.setAdapter(SliderAdapter(list))
        slider.setInterval(10000)

    }

    private fun setUpTabLayout(movieId: String) {

        adapterMovie=MovieViewPagerAdapter(supportFragmentManager,lifecycle,movieId)
        mViewBinding.vp2MovieDet.adapter=adapterMovie
        TabLayoutMediator(mViewBinding.tlMovieDet, mViewBinding.vp2MovieDet){tab,position->
            when(position){
                0-> tab.text="Info"
                1-> tab.text="Cast"
                2-> tab.text="Reviews"
                3-> tab.text="Similar"
            }
        }.attach()
    }

    private fun setUpToolbar(){
        mViewBinding.collapsingToolbar.setTitle("Movie Detail")
    }

    companion object{
        const val MOVIE_ID = "movieId"

        fun getInstance(context: Context,movieId : String) = Intent(context, MovieDetailActivity::class.java).apply {
            putExtra(MOVIE_ID,movieId)
        }
    }

}