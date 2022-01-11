package com.codeinglogs.tvshowdetail.ui.fragment.tvshowseason

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.tvshowseasondetails.TvShowSeasonDetailsViewModel
import com.codeinglogs.tvshowdetail.databinding.FragmentTvShowEpisodeBinding
import com.codeinglogs.tvshowdetail.ui.adapter.tvshow.TvShowEpisodeAdapter

class TvShowSeasonEpisodeFragment  : BaseFragment<TvShowSeasonDetailsViewModel, FragmentTvShowEpisodeBinding>(){

    lateinit var tvShowEpisodeAdapter: TvShowEpisodeAdapter

    override val mViewModel: TvShowSeasonDetailsViewModel by activityViewModels()
    override fun getViewBinding() = FragmentTvShowEpisodeBinding.inflate(layoutInflater)

    override fun onBinding() {

        init()
        tvShowSeasonEpisodeObserve()

    }

    private fun init(){
        setUpCastAdapter()
    }

    private fun setUpCastAdapter() {
        tvShowEpisodeAdapter = TvShowEpisodeAdapter()
        mViewBinding.rvTvShowEpisode.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        mViewBinding.rvTvShowEpisode.adapter=this.tvShowEpisodeAdapter


    }

    private fun tvShowSeasonEpisodeObserve(){

        mViewModel.tvShowSeasonDetails.observe(this){
            it.peekContent()?.let{it ->
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
                        tvShowEpisodeAdapter.submitList(it.data.tvShowSeasonsResponse.episodes)
                    }
                }
            }
        }
    }

}