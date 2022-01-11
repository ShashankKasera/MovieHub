package com.codeinglogs.tvshowdetail.ui.fragment.tvshow

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.tvshowdetails.TvShowDetailViewModel
import com.codeinglogs.tvshowdetail.ui.adapter.tvshow.TvShowSimilarAdapter
import com.codeinglogs.tvshowdetail.databinding.FragmentTvShowSimilarBinding



class TvShowSimilarFragment : BaseFragment<TvShowDetailViewModel, FragmentTvShowSimilarBinding>() {

    private lateinit var tvShowSimilarAdapter: TvShowSimilarAdapter

    override val mViewModel: TvShowDetailViewModel by activityViewModels()
    override fun getViewBinding() = FragmentTvShowSimilarBinding.inflate(layoutInflater)

    override fun onBinding() {

        init()
        tvShowSimilarObserve()
    }

    private fun init(){
        setUpSimilarAdapter()
    }

    private fun setUpSimilarAdapter() {
        tvShowSimilarAdapter = TvShowSimilarAdapter()
        mViewBinding.rvTvShowSimiler.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        mViewBinding.rvTvShowSimiler.adapter=this.tvShowSimilarAdapter


    }

    private fun tvShowSimilarObserve(){
        mViewModel.tvShowDetails.observe(this){
            it.peekContent().let{it ->
                when(it){
                    is State.Failed -> {
                        Log.i("gjwk", "Failed: TvShowDetailActivity ${it.message}")
                        showProgressBar(false)
                    }
                    is State.Loading -> {
                        Log.i("gjwk", "Loading: TvShowDetailActivity ${it.data}")
                        showProgressBar(true)
                    }
                    is State.Success -> {
                        Log.i("gjwk", "Success: TvShowDetailActivity ${it.data}")

                        showProgressBar(false)

                        tvShowSimilarAdapter.submitList(it.data.tvShowSimilarResponse.results)

                    }
                }
            }
        }
    }

}