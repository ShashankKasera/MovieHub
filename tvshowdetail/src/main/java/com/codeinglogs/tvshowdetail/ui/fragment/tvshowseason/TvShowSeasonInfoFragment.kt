package com.codeinglogs.tvshowdetail.ui.fragment.tvshowseason

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.tvshow.tvshowseasondetails.TvShowSeasonDetailsDisplay
import com.codeinglogs.presentation.viewmodel.tvshowseasondetails.TvShowSeasonDetailsViewModel
import com.codeinglogs.tvshowdetail.databinding.FragmentTvShowSeasonInfoBinding
import com.codeinglogs.tvshowdetail.ui.adapter.tvshowseason.TvShowSeasonCrewAdapter
import com.codeinglogs.tvshowdetail.ui.adapter.tvshowseason.TvShowSeasonPosterAdapter
import com.codeinglogs.tvshowdetail.ui.adapter.tvshowseason.TvShowSeasonVideoAdapter


class TvShowSeasonInfoFragment() : BaseFragment<TvShowSeasonDetailsViewModel, FragmentTvShowSeasonInfoBinding>(){

    private lateinit var tvShowSeasonVideoAdapter: TvShowSeasonVideoAdapter
    private lateinit var tvShowSeasonPosterAdapter: TvShowSeasonPosterAdapter
    private lateinit var tvShowSeasonCrewAdapter: TvShowSeasonCrewAdapter

    override val mViewModel: TvShowSeasonDetailsViewModel by activityViewModels()
    override fun getViewBinding() = FragmentTvShowSeasonInfoBinding.inflate(layoutInflater)

    override fun onBinding() {

        init()
        tvShowSeasonDetailsObserve()

    }

    private fun init() {
        setUpCrewAdapter()
        setUpVideoAdapter()
        setUpPosterAdapter()
    }

    private fun tvShowSeasonDetailsObserve(){
        mViewModel.tvShowSeasonDetails.observe(this){
            it.peekContent().let{it ->
                when(it){
                    is State.Failed -> {
                        Log.i("wkjnv", "Failed: TvShowDetailActivity ${it.message}")
                        showProgressBar(false)
                    }
                    is State.Loading -> {
                        Log.i("wkjnv", "Loading: TvShowDetailActivity ${it.data}")
                        showProgressBar(true)
                    }
                    is State.Success -> {
                        Log.i("wkjnv", "Success: TvShowDetailActivity ${it.data}")

                        showProgressBar(false)

                        setDetails(it)
                        setCrew(it)
                        setTrailer(it)
                        setMedia(it)
                    }
                }
            }
        }
    }

    private fun setDetails(it: State.Success<TvShowSeasonDetailsDisplay>){

        mViewBinding.tvTvShowNameTvShowSeasonInfo.text=it.data.tvShowSeasonsResponse.name
        mViewBinding.tvDescriptionTvShowSeasonInfo.text=it.data.tvShowSeasonsResponse.overview

        if(it.data.tvShowSeasonsResponse.air_date.length>4)
            mViewBinding.tvYearTvShowSeasonInfo.text=it.data.tvShowSeasonsResponse.air_date.substring(0,4)
        else
            mViewBinding.tvYearTvShowSeasonInfo.text=it.data.tvShowSeasonsResponse.air_date

    }

    private  fun  setCrew(it: State.Success<TvShowSeasonDetailsDisplay>) {
        tvShowSeasonCrewAdapter.submitList(it.data.tvShowSeasonsCreditsResponse.crew)
    }

    private fun setUpCrewAdapter() {
        tvShowSeasonCrewAdapter = TvShowSeasonCrewAdapter()
        mViewBinding.rvCrewTvShowSeasonInfo.layoutManager= GridLayoutManager(context,2)
        mViewBinding.rvCrewTvShowSeasonInfo.adapter=this.tvShowSeasonCrewAdapter


    }

    private fun setTrailer(it: State.Success<TvShowSeasonDetailsDisplay>){
        tvShowSeasonVideoAdapter.submitList(it.data.tvShowsSeasonVideosResponse.results)

    }

    private fun setUpVideoAdapter() {
        tvShowSeasonVideoAdapter = TvShowSeasonVideoAdapter()
        mViewBinding.rvVideoTvShowSeasonInfo.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvVideoTvShowSeasonInfo.adapter=this.tvShowSeasonVideoAdapter
    }

    private fun setMedia(it: State.Success<TvShowSeasonDetailsDisplay>){
        tvShowSeasonPosterAdapter.submitList(it.data.tvShowSeasonImageResponse.posters)

    }

    private fun setUpPosterAdapter() {
        tvShowSeasonPosterAdapter = TvShowSeasonPosterAdapter()

        mViewBinding.rvPosterTvShowSeasonInfo.setNestedScrollingEnabled(false)
        mViewBinding.rvPosterTvShowSeasonInfo.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvPosterTvShowSeasonInfo.adapter=this.tvShowSeasonPosterAdapter

    }

}