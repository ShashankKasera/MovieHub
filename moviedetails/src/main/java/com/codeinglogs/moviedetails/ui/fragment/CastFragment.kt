package com.codeinglogs.moviedetails.ui.fragment

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.moviedetails.ui.adapter.CastAdapter
import com.codeinglogs.moviedetails.databinding.FragmentCastBinding
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.moviedetail.MovieDetailViewModel

private const val TAG = "123CastFragment"

class CastFragment : BaseFragment<MovieDetailViewModel, FragmentCastBinding>() {

    private lateinit var castAdapter: CastAdapter
    override val mViewModel: MovieDetailViewModel by activityViewModels()

    override fun onBinding() {

        mViewModel.movieDetails.observe(this){
            it.peekContent().let{it ->
                when(it){
                    is State.Failed -> {
                        Log.i(TAG, "Failed: MovieDetailActivity ${it.message}")
                        showProgressBar(false)
                    }
                    is State.Loading -> {
                        Log.i(TAG, "Loading: MovieDetailActivity ${it.data}")
                        showProgressBar(true)
                    }
                    is State.Success -> {
                        Log.i(TAG, "Success: MovieDetailActivity ${it.data}")

                        showProgressBar(false)

                        setUpCastAdapter()
                        castAdapter.submitList(it.data.movieCreditsResponse.cast)

                    }
                }
            }
        }
    }

    private fun setUpCastAdapter() {
        castAdapter = CastAdapter()
        mViewBinding.rvMovieCast.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        mViewBinding.rvMovieCast.adapter=this.castAdapter


    }
    override fun getViewBinding() = FragmentCastBinding.inflate(layoutInflater)


}