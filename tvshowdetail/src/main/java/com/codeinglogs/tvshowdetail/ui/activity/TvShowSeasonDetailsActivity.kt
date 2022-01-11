package com.codeinglogs.tvshowdetail.ui.activity

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.viewModels
import com.codeinglogs.core.PicassoImageLoadingService
import com.codeinglogs.core.SliderAdapter
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.tvshow.tvshowseasondetails.seasons.TvShowEpisode
import com.codeinglogs.presentation.viewmodel.tvshowseasondetails.TvShowSeasonDetailsViewModel
import com.codeinglogs.tvshowdetail.databinding.ActivityTvShowSeasonDetailsBinding
import com.codeinglogs.tvshowdetail.ui.adapter.tvshowseason.TvShowSeasonViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import ss.com.bannerslider.Slider
@AndroidEntryPoint
class TvShowSeasonDetailsActivity : BaseActivity<TvShowSeasonDetailsViewModel, ActivityTvShowSeasonDetailsBinding>(){

    lateinit var tvShowSeasonViewPagerAdapter: TvShowSeasonViewPagerAdapter


    override val mViewModel: TvShowSeasonDetailsViewModel by viewModels()

    override fun getViewBinding()= ActivityTvShowSeasonDetailsBinding.inflate(layoutInflater)

    override fun onBinding() {

        init()

        TvShowSeasonDetailsObserve()
    }

    private fun init(){

        val tvShowId = intent.getStringExtra(TV_SHOW_ID)
        val tvShowSeasonNumber = intent.getIntExtra(TV_SHOW_SEASON_NUMBER,-1)
        Log.i("nkwnk", "init: ${tvShowId}  ${tvShowSeasonNumber}")
        tvShowId?.let {
            mViewModel.getTvShowSeasonDetails(it,tvShowSeasonNumber)
        }

        setUpToolbar()
        setUpTabLayout()
    }
    private  fun addSlider (slider: Slider, results: List<TvShowEpisode>, ) {


        val list = ArrayList<String>()
        for (result in results)
            list.add(IMAGE_BASE_URL_500+result.still_path)

        Slider.init(PicassoImageLoadingService());
        slider.setAdapter(SliderAdapter(list))
        slider.setInterval(10000)

    }

    private fun setUpTabLayout(){

        tvShowSeasonViewPagerAdapter= TvShowSeasonViewPagerAdapter(supportFragmentManager,lifecycle)

        mViewBinding.vp2TvShowSeasonDet.adapter=tvShowSeasonViewPagerAdapter

        TabLayoutMediator(mViewBinding.tlTvShowSeasonDet, mViewBinding.vp2TvShowSeasonDet){tab,position->
            when(position){
                0-> tab.text="Info"
                1-> tab.text="Episodes"
                2-> tab.text="Cast"
            }
        }.attach()
    }

    private fun setUpToolbar(){
        mViewBinding.ctbTvShowSeasonDet.setTitle("Tv Show Detail")
    }

    private fun TvShowSeasonDetailsObserve(){

        mViewModel.tvShowSeasonDetails.observe(this){
            it.contentIfNotHandled?.let{it ->
                when(it){
                    is State.Failed -> {
                        Log.i("fnjk", "Failed: TvShowSeasonDetailsActivity ${it.message}")
                        showProgressBar(false)
                    }
                    is State.Loading -> {
                        Log.i("fnjk", "Loading: TvShowSeasonDetailsActivity ${it.data}")
                        showProgressBar(true)
                    }
                    is State.Success -> {
                        Log.i("fnjk", "Success: TvShowSeasonDetailsActivity ${it.data}")
                        showProgressBar(false)

                        addSlider(mViewBinding.bsTvTvShowSeasonDet,it.data.tvShowSeasonsResponse.episodes)
                    }
                }
            }
        }
    }

    companion object{
        const val TV_SHOW_ID = "tvShowId"
        const val TV_SHOW_SEASON_NUMBER = "tvShowSeasonNumber"

        fun getInstance(context: Context,tvShowId:String,season_number:Int) = Intent(context, TvShowSeasonDetailsActivity::class.java)
            .apply {
                putExtra(TV_SHOW_ID,tvShowId)
                putExtra(TV_SHOW_SEASON_NUMBER,season_number)
            }
    }

}