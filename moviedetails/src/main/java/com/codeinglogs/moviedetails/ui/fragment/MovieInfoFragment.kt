package com.codeinglogs.moviedetails.ui.fragment

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviedetails.databinding.FragmentMovieInfosBinding
import com.codeinglogs.moviedetails.ui.activity.MovieCrewActivity
import com.codeinglogs.moviedetails.ui.adapter.MovieGenresAdapter
import com.codeinglogs.moviedetails.ui.adapter.MovieVideoAdapter
import com.codeinglogs.moviedetails.ui.adapter.MovieCrewAdapter
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.movies.moviedetail.MovieDetailsDisplay
import com.codeinglogs.presentation.viewmodel.moviedetail.MovieDetailViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


private const val TAG = "123InfoFragment"

class MovieInfoFragment : BaseFragment<MovieDetailViewModel, FragmentMovieInfosBinding>(){

    private lateinit var movieGenresAdapter: MovieGenresAdapter
    private lateinit var movieVideoAdapter: MovieVideoAdapter
    private lateinit var movieCrewAdapter: MovieCrewAdapter

    override val mViewModel: MovieDetailViewModel by activityViewModels()
    override fun getViewBinding() = FragmentMovieInfosBinding.inflate(layoutInflater)

    override fun onBinding() {

        init()
        movieInfoObserve()

    }

    private fun init() {
        initProgressBar(mViewBinding.movieDetailLoader)
        setUpGenresAdapter()
        setUpCrewAdapter()
        setUpVideoAdapter()
    }

    private fun movieInfoObserve(){
        mViewModel.movieDetails.observe(this){
            it.peekContent()?.let{it ->
                when(it){
                    is State.Failed -> {
                        Log.i(TAG, "Failed: 123InfoFragment ${it.message}")
                        showProgressBar(true)
                    }
                    is State.Loading -> {
                        Log.i(TAG, "Loading: 123InfoFragment ${it.data}")

                        if(it.data!=null&&it.data?.movieCreditsResponse?.crew?.isNotEmpty() == true){
                            setDetails(it.data!!)
                            setCrew(it.data!!)
                            setTrailer(it.data!!)
                            setFact(it.data!!)
                            setMedia(it.data!!)
                            setProductionCompanies(it.data!!)
                            showProgressBar(false)
                        }
                        else{
                            showProgressBar(true)
                        }
                    }
                    is State.Success -> {
                        Log.i(TAG, "Success: 123InfoFragment ${it.data}")

                        lifecycleScope.launch(Dispatchers.Main) {
                            delay(6000)
                            showProgressBar(false)

                            setDetails(it.data)
                            setCrew(it.data)
                            setTrailer(it.data)
                            setFact(it.data)
                            setMedia(it.data)
                            setProductionCompanies(it.data)

                            mViewBinding.tvShowAllMovieInfo.setOnClickListener(){
                                startActivity(MovieCrewActivity.getInstance(requireContext(),mViewModel.movieId))
                            }
                        }


                    }
                }
            }
        }
    }


    private fun setDetails(it: MovieDetailsDisplay){

        mViewBinding.tvTimeMovieInfo.text=convertNumberToHoursMinutes(it.movieInfoResponse.runtime)
        mViewBinding.tvMovieNameMovieInfo.text=it.movieInfoResponse.title
        mViewBinding.tvDescriptionMovieInfo.text=it.movieInfoResponse.overview

        if(it.movieInfoResponse.release_date.length>4)
            mViewBinding.tvYearMovieInfo.text=it.movieInfoResponse.release_date.substring(0,4)
        else
            mViewBinding.tvYearMovieInfo.text=it.movieInfoResponse.release_date

        movieGenresAdapter.submitList(it.movieInfoResponse.genres)
    }

    private fun convertNumberToHoursMinutes(runtime:Int):kotlin.String{
        val hours = runtime / 60
        val mins = (runtime %  60)

        return "$hours Hours: $mins Minutes"
    }

    private fun setUpGenresAdapter() {
        movieGenresAdapter = MovieGenresAdapter()
        mViewBinding.rvMovieTypeMovieInfo.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvMovieTypeMovieInfo.adapter=this.movieGenresAdapter


    }

    private fun setCrew(it: MovieDetailsDisplay) {
        movieCrewAdapter.submitList(it.movieCreditsResponse.crew)
    }

    private fun setUpCrewAdapter() {
        movieCrewAdapter = MovieCrewAdapter()
        mViewBinding.rvCrewMovieInfo.layoutManager= GridLayoutManager(context,2)
        mViewBinding.rvCrewMovieInfo.adapter=this.movieCrewAdapter


    }

    private fun setTrailer(it: MovieDetailsDisplay){
        movieVideoAdapter.submitList(it.MovieVideosResponse.results)
    }

    private fun setUpVideoAdapter() {
        movieVideoAdapter = MovieVideoAdapter()
        mViewBinding.rvVideoMovieInfo.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvVideoMovieInfo.adapter=this.movieVideoAdapter
    }

    private fun setFact(it: MovieDetailsDisplay){
        mViewBinding.tvTitleFactMovieInfo.text=it.movieInfoResponse.title
        mViewBinding.tvStatusFactMovieInfo.text=it.movieInfoResponse.status
        mViewBinding.tvReleaseDateFactMovieInfo.text=it.movieInfoResponse.release_date
        mViewBinding.tvOriginalLanguageFactMovieInfo.text=it.movieInfoResponse.original_language
        mViewBinding.tvRuntimeFactMovieInfo.text=convertNumberToHoursMinutes(it.movieInfoResponse.runtime)
        mViewBinding.tvBudgetFactMovieInfo.text=it.movieInfoResponse.budget.toString()
        mViewBinding.tvRevenueFactMovieInfo.text=it.movieInfoResponse.revenue.toString()
        mViewBinding.tvRevenueFactMovieInfo.text=it.movieInfoResponse.revenue.toString()

    }

    private fun setMedia(it: MovieDetailsDisplay){

        if(it.movieIMagesResponse.posters.size>0) {
            mViewBinding.ivPosterMovieInfo.load(IMAGE_BASE_URL_500 + it.movieIMagesResponse.posters.get(0).file_path)
            mViewBinding.tvNumberOfPosterMovieInfo.text = it.movieIMagesResponse.posters.size.toString() + " Posters"
        }
        if(it.movieIMagesResponse.backdrops.size>0) {
            mViewBinding.ivBackdropMovieInfo.load(IMAGE_BASE_URL_500 + it.movieIMagesResponse.backdrops.get(0).file_path)
            mViewBinding.tvNumberOfBackdropMovieInfo.text = it.movieIMagesResponse.backdrops.size.toString() + " Backdrops"
        }
    }

    private fun setProductionCompanies(it: MovieDetailsDisplay){
        var production_companies=""
        for (i in 1..(it.movieInfoResponse.production_companies.size-1 )) {
            production_companies+=it.movieInfoResponse.production_companies.get(i).name+", "
        }
        mViewBinding.tvProductionCompaniesMovieInfo.text=production_companies
    }

}