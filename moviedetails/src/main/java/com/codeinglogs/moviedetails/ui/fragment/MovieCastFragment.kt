package com.codeinglogs.moviedetails.ui.fragment

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.core.extension.showToast
import com.codeinglogs.moviedetails.ui.adapter.MovieCastAdapter
import com.codeinglogs.moviedetails.databinding.FragmentMovieCastBinding
import com.codeinglogs.moviedetails.ui.activity.MovieCrewActivity
import com.codeinglogs.moviedetails.ui.route.PersonRoute
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.viewmodel.moviedetail.MovieDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "123CastFragment"
@AndroidEntryPoint
class MovieCastFragment : BaseFragment<MovieDetailViewModel, FragmentMovieCastBinding>() {

    private lateinit var movieCastAdapter: MovieCastAdapter

    override val mViewModel: MovieDetailViewModel by activityViewModels()
    override fun getViewBinding() = FragmentMovieCastBinding.inflate(layoutInflater)


    override fun onBinding() {
        init()
        movieCastObserve()
    }

    private fun init() {
        initProgressBar(mViewBinding.movieDetailCastLoader)
        setUpCastAdapter()
    }

    private fun movieCastObserve(){

        mViewModel.movieDetails.observe(this){
            it.peekContent()?.let{it ->
                when(it){
                    is State.Failed -> {
                        Log.i("ghwighihnigi", "Failed: 123InfoFragment ${it.message}")
                        showProgressBar(false)
                        showToast(it.message)
                    }
                    is State.Loading -> {
                        Log.i(TAG, "Loading: 123InfoFragment ${it.data}")

                        Log.i("ghwighihnigi", "movieCastObserve: ${it.data}     ${it.data?.movieCreditsResponse?.cast?.isNotEmpty()}")
                        if(it.data!=null && it.data?.movieCreditsResponse?.cast?.isNotEmpty() == true){
                            movieCastAdapter.submitList(it.data!!.movieCreditsResponse.cast)
                            showProgressBar(false)
                        }
                        else{
                            showProgressBar(true)
                        }
                    }
                    is State.Success -> {
                        Log.i(TAG, "Success: 123InfoFragment ${it.data}")

                        showProgressBar(false)

                        movieCastAdapter.submitList(it.data.movieCreditsResponse.cast)

                    }
                }
            }
        }

    }
    private fun setUpCastAdapter() {
        movieCastAdapter = MovieCastAdapter()
        mViewBinding.rvMovieCast.layoutManager= LinearLayoutManager(
            context, LinearLayoutManager.VERTICAL,false)
        mViewBinding.rvMovieCast.adapter=this.movieCastAdapter


    }

}