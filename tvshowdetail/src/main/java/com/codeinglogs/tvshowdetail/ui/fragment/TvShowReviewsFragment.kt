package com.codeinglogs.tvshowdetail.ui.fragment

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.tvshowdetails.TvShowDetailViewModel
import com.codeinglogs.tvshowdetail.databinding.FragmentTvShowReviewsBinding
import com.codeinglogs.tvshowdetail.ui.adapter.TvShowReviewAdapter

class TvShowReviewsFragment : BaseFragment<TvShowDetailViewModel, FragmentTvShowReviewsBinding>(){

    override val mViewModel: TvShowDetailViewModel by activityViewModels()

    override fun getViewBinding() = FragmentTvShowReviewsBinding.inflate(layoutInflater)

    private lateinit var tvShowReviewAdapter: TvShowReviewAdapter

    override fun onBinding() {

        setUpTvShowReviewAdapter()

        mViewModel.tvShowDetails.observe(this){
            it.peekContent().let{it ->
                when(it){
                    is State.Failed -> {
                        Log.i("jwn", "Failed: TvShowReviewsFragment ${it.message}")
                        showProgressBar(false)
                    }
                    is State.Loading -> {
                        Log.i("jwn", "Loading: TvShowReviewsFragment ${it.data}")
                        showProgressBar(true)
                    }
                    is State.Success -> {
                        Log.i("jwn", "Success: TvShowReviewsFragment ${it.data}")

                        showProgressBar(false)
                        Log.i("jwn", "onBinding: ${it.data.tvShowReviewsResponse.results}")
                        tvShowReviewAdapter.submitList(it.data.tvShowReviewsResponse.results)

                    }
                }
            }
        }
    }

    private fun setUpTvShowReviewAdapter() {
        tvShowReviewAdapter = TvShowReviewAdapter()
        mViewBinding.rvTvShowReview.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        mViewBinding.rvTvShowReview.adapter=this.tvShowReviewAdapter


    }

}