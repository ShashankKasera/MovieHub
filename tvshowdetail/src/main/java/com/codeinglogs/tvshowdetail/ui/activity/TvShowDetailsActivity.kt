package com.codeinglogs.tvshowdetail.ui.activity

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.viewModels
import com.codeinglogs.core.PicassoImageLoadingService
import com.codeinglogs.core.SliderAdapter
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_YOUTUBE
import com.codeinglogs.moviehub.constant.IMAGE_back_YOUTUBE
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.video.TvShowsVideos
import com.codeinglogs.presentation.viewmodel.tvshowdetails.TvShowDetailViewModel
import com.codeinglogs.tvshowdetail.databinding.ActivityTvShowDetailsBinding
import com.codeinglogs.tvshowdetail.ui.adapter.tvshow.TvShowViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import ss.com.bannerslider.Slider

private const val TAG = "123TvShowDetailsActivity"

@AndroidEntryPoint
class TvShowDetailsActivity : BaseActivity<TvShowDetailViewModel, ActivityTvShowDetailsBinding>(){

    lateinit var tvShowViewPagerAdapter: TvShowViewPagerAdapter

    override val mViewModel:TvShowDetailViewModel by viewModels()

    override fun getViewBinding()= ActivityTvShowDetailsBinding.inflate(layoutInflater)

    override fun onBinding() {

        init()
        tvShowDetailObserve()
    }

    private fun init(){
        val tvShowId = intent.getStringExtra(TV_SHOW_ID)

        tvShowId?.let {
            mViewModel.tvShowId=it
            mViewModel.getTvShowDetails(it)
        }

        setUpTabLayout()
        setUpToolbar()
    }

    private  fun addSlider (slider: Slider, results: List<TvShowsVideos>, ) {


        val list = ArrayList<String>()
        for (result in results)
            list.add(IMAGE_BASE_URL_YOUTUBE +result.key+ IMAGE_back_YOUTUBE)

        Slider.init(PicassoImageLoadingService());
        slider.setAdapter(SliderAdapter(list))
        slider.setInterval(10000)

    }

    private fun setUpTabLayout(){

        tvShowViewPagerAdapter= TvShowViewPagerAdapter(supportFragmentManager,lifecycle)

        mViewBinding.vp2TvShowDet.adapter=tvShowViewPagerAdapter

        TabLayoutMediator(mViewBinding.tlTvShowDet, mViewBinding.vp2TvShowDet){tab,position->
            when(position){
                0-> tab.text="Info"
                1-> tab.text="Cast"
                2-> tab.text="Reviews"
                3-> tab.text="Similer"
            }
        }.attach()
    }

    private fun setUpToolbar(){
        mViewBinding.ctbTvShowDet.setTitle("Tv Show Detail")
    }

    private fun tvShowDetailObserve(){

        mViewModel.tvShowDetails.observe(this){
            it.contentIfNotHandled?.let{it ->
                when(it){
                    is State.Failed -> {
                        Log.i("fnjk", "Failed: TvShowDetailActivity ${it.message}")
                        showProgressBar(false)
                    }
                    is State.Loading -> {
                        Log.i("fnjk", "Loading: TvShowDetailActivity ${it.data}")
                        showProgressBar(true)
                    }
                    is State.Success -> {
                        Log.i("fnjk", "Success: TvShowDetailActivity ${it.data}")
                        showProgressBar(false)

                        addSlider(mViewBinding.bsTvTvShowDet,it.data.tvShowVideosResponse.results)
                    }
                }
            }
        }
    }

    companion object{
        const val TV_SHOW_ID = "tvShowId"

        fun getInstance(context: Context,tvShowId:String) = Intent(context, TvShowDetailsActivity::class.java)
            .apply {
                putExtra(TV_SHOW_ID,tvShowId)
            }
    }

}