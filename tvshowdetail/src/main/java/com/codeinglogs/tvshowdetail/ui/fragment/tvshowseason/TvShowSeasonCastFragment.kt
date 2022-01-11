package com.codeinglogs.tvshowdetail.ui.fragment.tvshowseason

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.tvshowseasondetails.TvShowSeasonDetailsViewModel
import com.codeinglogs.tvshowdetail.databinding.FragmentTvShowCastBinding
import com.codeinglogs.tvshowdetail.ui.adapter.tvshowseason.TvShowSeasonCastAdapter

class TvShowSeasonCastFragment  : BaseFragment<TvShowSeasonDetailsViewModel, FragmentTvShowCastBinding>(){

    private lateinit var tvShowSeasonCastAdapter: TvShowSeasonCastAdapter

    override val mViewModel: TvShowSeasonDetailsViewModel by activityViewModels()
    override fun getViewBinding() = FragmentTvShowCastBinding.inflate(layoutInflater)

    override fun onBinding() {
        init()
        tvShowSeasonCastObserve()
    }

    private fun init(){
        setUpCastAdapter()
    }

    private fun setUpCastAdapter() {
        tvShowSeasonCastAdapter = TvShowSeasonCastAdapter()
        mViewBinding.rvTvShowCast.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        mViewBinding.rvTvShowCast.adapter=this.tvShowSeasonCastAdapter
    }

    private fun tvShowSeasonCastObserve(){

        mViewModel.tvShowSeasonDetails.observe(this){
            it.peekContent().let{it ->
                when(it){
                    is State.Failed -> {
                        Log.i("fqnk", "Failed: MovieDetailActivity ${it.message}")
                        showProgressBar(false)
                    }
                    is State.Loading -> {
                        Log.i("fqnk", "Loading: MovieDetailActivity ${it.data}")
                        showProgressBar(true)
                    }
                    is State.Success -> {
                        Log.i("fqnk", "Success: MovieDetailActivity ${it.data}")

                        showProgressBar(false)

                        tvShowSeasonCastAdapter.submitList(it.data.tvShowSeasonsCreditsResponse.cast)

                    }
                }
            }
        }
    }
}