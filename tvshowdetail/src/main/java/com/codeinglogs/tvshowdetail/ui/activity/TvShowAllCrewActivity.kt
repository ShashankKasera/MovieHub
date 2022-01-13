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
import com.codeinglogs.presentation.viewmodel.moviedetail.MovieDetailViewModel
import com.codeinglogs.presentation.viewmodel.tvshowdetails.TvShowDetailViewModel
import com.codeinglogs.tvshowdetail.R
import com.codeinglogs.tvshowdetail.databinding.ActivityTvShowAllCrewBinding
import com.codeinglogs.tvshowdetail.ui.adapter.tvshow.TvShowAllCrewAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowAllCrewActivity : BaseActivity<TvShowDetailViewModel, ActivityTvShowAllCrewBinding>()  {


    private lateinit var tvShowAllCrewAdapter: TvShowAllCrewAdapter

    override val mViewModel: TvShowDetailViewModel by viewModels()

    override fun getViewBinding()= ActivityTvShowAllCrewBinding.inflate(layoutInflater)

    override fun onBinding() {
        init()
        movieInfoObserve()
    }

    private fun init() {

        val movieId = intent.getStringExtra(TVSHOWID)

        movieId?.let {
            mViewModel.getTvShowDetails(it)
        }
        setUpAllCrewAdapter()

    }

    private fun setUpAllCrewAdapter() {
        tvShowAllCrewAdapter = TvShowAllCrewAdapter()
        mViewBinding.rvTvShowCrew.layoutManager= LinearLayoutManager(this,)
        mViewBinding.rvTvShowCrew.adapter=this.tvShowAllCrewAdapter
    }

    private fun movieInfoObserve(){
        mViewModel.tvShowDetails.observe(this){
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

                        tvShowAllCrewAdapter.submitList(it.data.tvShowCreditsResponse.crew)

                    }
                }
            }
        }
    }

    companion object{
        const val TVSHOWID = "tvShowId"

        fun getInstance(context: Context, tvShowId : String) = Intent(context, TvShowAllCrewActivity::class.java)
            .apply {
                putExtra(TVSHOWID,tvShowId)
            }

    }
}