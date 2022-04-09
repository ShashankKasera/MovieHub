package com.codeinglogs.tvshowdetail.ui.fragment.tvshow

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.core.extension.showToast
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.tvshowdetails.TvShowDetailViewModel
import com.codeinglogs.tvshowdetail.databinding.FragmentTvShowCastBinding
import com.codeinglogs.tvshowdetail.ui.adapter.tvshow.TvShowCastAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvShowCastFragment  : BaseFragment<TvShowDetailViewModel, FragmentTvShowCastBinding>(){

    private lateinit var tvShowCastAdapter: TvShowCastAdapter

    override val mViewModel: TvShowDetailViewModel by activityViewModels()
    override fun getViewBinding() = FragmentTvShowCastBinding.inflate(layoutInflater)

    override fun onBinding() {

        init()
        TvShowCastObserve()
    }

    private fun init(){
        initProgressBar(mViewBinding.tvshowDetailCastLoader)
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
                        Log.i("ghwighihnigi", "Failed: 123InfoFragment ${it.message}")
                        showProgressBar(false)
                        showToast(it.message)
                    }
                    is State.Loading -> {
                        Log.i("ghwighihnigi", "Loading: 123InfoFragment ${it.data}")

                        Log.i("ghwighihnigi", "movieCastObserve: ${it.data}     ${it.data?.tvShowCreditsResponse?.cast?.isNotEmpty()}")
                        if(it.data!=null && it.data?.tvShowCreditsResponse?.cast?.isNotEmpty() == true){
                            tvShowCastAdapter.submitList(it.data!!.tvShowCreditsResponse.cast)
                            showProgressBar(false)
                        }
                        else{
                            showProgressBar(true)
                        }
                    }
                    is State.Success -> {
                        Log.i("ghwighihnigi", "Success: 123InfoFragment ${it.data}")

                        showProgressBar(false)

                        tvShowCastAdapter.submitList(it.data.tvShowCreditsResponse.cast)

                    }
                }
            }
        }
    }


}