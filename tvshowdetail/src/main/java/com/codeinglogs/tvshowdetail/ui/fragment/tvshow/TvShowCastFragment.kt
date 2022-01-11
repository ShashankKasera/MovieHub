package com.codeinglogs.tvshowdetail.ui.fragment.tvshow

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.tvshowdetails.TvShowDetailViewModel
import com.codeinglogs.tvshowdetail.databinding.FragmentTvShowCastBinding
import com.codeinglogs.tvshowdetail.ui.adapter.tvshow.TvShowCastAdapter

class TvShowCastFragment  : BaseFragment<TvShowDetailViewModel, FragmentTvShowCastBinding>(){

    private lateinit var tvShowCastAdapter: TvShowCastAdapter

    override val mViewModel: TvShowDetailViewModel by activityViewModels()
    override fun getViewBinding() = FragmentTvShowCastBinding.inflate(layoutInflater)

    override fun onBinding() {

        init()
        TvShowCastObserve()
    }

    private fun init(){
        setUpTvShowCastAdapter()
    }
    private fun setUpTvShowCastAdapter() {
        tvShowCastAdapter = TvShowCastAdapter()
        mViewBinding.rvTvShowCast.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        mViewBinding.rvTvShowCast.adapter=this.tvShowCastAdapter
    }

    private fun TvShowCastObserve(){
        mViewModel.tvShowDetails.observe(this){
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
                        tvShowCastAdapter.submitList(it.data.tvShowCreditsResponse.cast)

                    }
                }
            }
        }
    }


}