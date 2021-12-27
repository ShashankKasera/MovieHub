package com.codeinglogs.moviedetails.ui.fragment

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.moviedetails.databinding.FragmentCastBinding
import com.codeinglogs.moviedetails.databinding.FragmentSimilarBinding
import com.codeinglogs.moviedetails.ui.adapter.CastAdapter
import com.codeinglogs.moviedetails.ui.adapter.SimilarAdapter
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.moviedetail.MovieDetailViewModel
import com.codeinglogs.presentation.viewmodel.trendingmovies.TrendingMoviesViewModel

private const val TAG = "123SimilerFragment"

class SimilerFragment : BaseFragment<MovieDetailViewModel, FragmentSimilarBinding>() {

    private lateinit var similarAdapter: SimilarAdapter
    override val mViewModel: MovieDetailViewModel by activityViewModels()

    override fun onBinding() {

        mViewModel.movieDetails.observe(this){
            it.peekContent()?.let{it ->
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

                        setUpSimilarAdapter()
                        similarAdapter.submitList(it.data.MovieSimilarResponse.results)

                    }
                }
            }
        }
    }

    private fun setUpSimilarAdapter() {
        similarAdapter = SimilarAdapter()
        mViewBinding.rvMovieSimiler.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        mViewBinding.rvMovieSimiler.adapter=this.similarAdapter


    }
    override fun getViewBinding() = FragmentSimilarBinding.inflate(layoutInflater)


}