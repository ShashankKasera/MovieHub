package com.codeinglogs.tvshowdetail.ui.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseActivity
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.tvshowdetails.TvShowDetailViewModel
import com.codeinglogs.presentation.viewmodel.tvshowseasondetails.TvShowSeasonDetailsViewModel
import com.codeinglogs.tvshowdetail.R
import com.codeinglogs.tvshowdetail.databinding.ActivityTvShowAllCrewBinding
import com.codeinglogs.tvshowdetail.databinding.ActivityTvShowSeasonAllCrewBinding
import com.codeinglogs.tvshowdetail.ui.adapter.tvshow.TvShowAllCrewAdapter
import com.codeinglogs.tvshowdetail.ui.adapter.tvshowseason.TvShowSeasonAllCrewAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowSeasonAllCrewActivity : BaseActivity<TvShowSeasonDetailsViewModel, ActivityTvShowSeasonAllCrewBinding>()  {


    private lateinit var tvShowSeasonAllCrewAdapter: TvShowSeasonAllCrewAdapter

    override val mViewModel: TvShowSeasonDetailsViewModel by viewModels()

    override fun getViewBinding()= ActivityTvShowSeasonAllCrewBinding.inflate(layoutInflater)

    override fun onBinding() {
        init()
        movieInfoObserve()
    }

    private fun init() {

        val tvShowId = intent.getStringExtra(TV_SHOW_ID)
        val tvShowSeasonNumber = intent.getIntExtra(TV_SHOW_SEASON_NUMBER,-1)
        Log.i("nkwnk", "init: ${tvShowId}  ${tvShowSeasonNumber}")
        tvShowId?.let {
            mViewModel.tvShowSeasonId=it
            mViewModel.getTvShowSeasonDetails(it,tvShowSeasonNumber)
        }
        setUpAllCrewAdapter()

    }

    private fun setUpAllCrewAdapter() {
        tvShowSeasonAllCrewAdapter = TvShowSeasonAllCrewAdapter()
        mViewBinding.rvTvShowSeasonCrew.layoutManager= LinearLayoutManager(this,)
        mViewBinding.rvTvShowSeasonCrew.adapter=this.tvShowSeasonAllCrewAdapter
    }

    private fun movieInfoObserve(){
        mViewModel.tvShowSeasonDetails.observe(this){
            it.peekContent()?.let{it ->
                when(it){
                    is State.Failed -> {
                        Log.i("jknck", "Failed: MovieDetailActivity ${it.message}")
                        showProgressBar(false)
                    }
                    is State.Loading -> {
                        Log.i("jknck", "Loading: MovieDetailActivity ${it.data}")
                        showProgressBar(true)
                    }
                    is State.Success -> {
                        Log.i("jknck", "Success: MovieDetailActivity ${it.data}")

                        showProgressBar(false)

                        tvShowSeasonAllCrewAdapter.submitList(it.data.tvShowSeasonsCreditsResponse.crew)

                    }
                }
            }
        }
    }

    companion object{
        const val TV_SHOW_ID = "tvShowId"
        const val TV_SHOW_SEASON_NUMBER = "tvShowSeasonNumber"

        fun getInstance(context: Context,tvShowId:String,season_number:Int) = Intent(context, TvShowSeasonAllCrewActivity::class.java)
            .apply {
                putExtra(TV_SHOW_ID,tvShowId)
                putExtra(TV_SHOW_SEASON_NUMBER,season_number)
            }

    }
}