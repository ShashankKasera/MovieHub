package com.codeinglogs.tvshowdetail.ui.fragment.tvshow

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.core.extension.showToast
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.tvshowdetails.TvShowDetailViewModel
import com.codeinglogs.tvshowdetail.databinding.FragmentTvShowReviewsBinding
import com.codeinglogs.tvshowdetail.ui.adapter.tvshow.TvShowReviewAdapter

class TvShowReviewsFragment : BaseFragment<TvShowDetailViewModel, FragmentTvShowReviewsBinding>(){

    private lateinit var tvShowReviewAdapter: TvShowReviewAdapter

    override val mViewModel: TvShowDetailViewModel by activityViewModels()
    override fun getViewBinding() = FragmentTvShowReviewsBinding.inflate(layoutInflater)

    override fun onBinding() {

        init()
        tvShowReviewsObserve()
    }

    private fun init(){
        initProgressBar(mViewBinding.tvshowDetailReviewLoader)
        setUpTvShowReviewAdapter()
    }

    private fun setUpTvShowReviewAdapter() {
        tvShowReviewAdapter = TvShowReviewAdapter()
        mViewBinding.rvTvShowReview.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        mViewBinding.rvTvShowReview.adapter=this.tvShowReviewAdapter
    }

    private fun tvShowReviewsObserve(){
        mViewModel.tvShowDetails.observe(this){
            it.peekContent().let{it ->
                when(it){
                    is State.Failed -> {
                        Log.i("giwnk", "Failed: MovieDetailActivity ${it.message}")
                        showProgressBar(false)
                        showToast(it.message)
                    }
                    is State.Loading -> {
                        Log.i("giwnk", "Loading: MovieDetailActivity ${it.data}")

                        if(it.data!=null && it.data?.tvShowReviewsResponse?.results?.isNotEmpty() == true){
                            tvShowReviewAdapter.submitList(it.data!!.tvShowReviewsResponse.results)
                            showProgressBar(false)
                        }
                        else{
                            showProgressBar(true)
                        }
                    }
                    is State.Success -> {
                        Log.i("giwnk", "Success: MovieDetailActivity ${it.data}")

                        showProgressBar(false)
                        Log.i("giwnk", "onBinding: ${it.data.tvShowReviewsResponse.results}")
                        tvShowReviewAdapter.submitList(it.data.tvShowReviewsResponse.results)

                    }
                }
            }
        }
    }
}