package com.codeinglogs.moviedetails.ui.fragment

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviedetails.databinding.FragmentMovieInfosBinding
import com.codeinglogs.moviedetails.ui.adapter.MovieGenresAdapter
import com.codeinglogs.moviedetails.ui.adapter.MovieVideoAdapter
import com.codeinglogs.moviedetails.ui.adapter.MovieCrewAdapter
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.movies.moviedetail.MovieDetailsDisplay
import com.codeinglogs.presentation.viewmodel.moviedetail.MovieDetailViewModel


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
        setUpGenresAdapter()
        setUpCrewAdapter()
        setUpVideoAdapter()
    }

    private fun movieInfoObserve(){
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

                        setDetails(it)
                        setCrew(it)
                        setTrailer(it)
                        setFact(it)
                        setMedia(it)
                        setProductionCompanies(it)



                    }
                }
            }
        }
    }

    private fun setDetails(it: State.Success<MovieDetailsDisplay>){

        mViewBinding.tvTimeMovieInfo.text=convertNumberToHoursMinutes(it.data.movieInfoResponse.runtime)
        mViewBinding.tvMovieNameMovieInfo.text=it.data.movieInfoResponse.title
        mViewBinding.tvDescriptionMovieInfo.text=it.data.movieInfoResponse.overview

        if(it.data.movieInfoResponse.release_date.length>4)
            mViewBinding.tvYearMovieInfo.text=it.data.movieInfoResponse.release_date.substring(0,4)
        else
            mViewBinding.tvYearMovieInfo.text=it.data.movieInfoResponse.release_date

        movieGenresAdapter.submitList(it.data.movieInfoResponse.genres)
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

    private fun setCrew(it: State.Success<MovieDetailsDisplay>) {
        movieCrewAdapter.submitList(it.data.movieCreditsResponse.crew)
    }

    private fun setUpCrewAdapter() {
        movieCrewAdapter = MovieCrewAdapter()
        mViewBinding.rvCrewMovieInfo.layoutManager= GridLayoutManager(context,2)
        mViewBinding.rvCrewMovieInfo.adapter=this.movieCrewAdapter


    }

    private fun setTrailer(it: State.Success<MovieDetailsDisplay>){
        movieVideoAdapter.submitList(it.data.MovieVideosResponse.results)
    }

    private fun setUpVideoAdapter() {
        movieVideoAdapter = MovieVideoAdapter()
        mViewBinding.rvVideoMovieInfo.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvVideoMovieInfo.adapter=this.movieVideoAdapter
    }

    private fun setFact(it: State.Success<MovieDetailsDisplay>){
        mViewBinding.tvTitleFactMovieInfo.text=it.data.movieInfoResponse.title
        mViewBinding.tvStatusFactMovieInfo.text=it.data.movieInfoResponse.status
        mViewBinding.tvReleaseDateFactMovieInfo.text=it.data.movieInfoResponse.release_date
        mViewBinding.tvOriginalLanguageFactMovieInfo.text=it.data.movieInfoResponse.original_language
        mViewBinding.tvRuntimeFactMovieInfo.text=convertNumberToHoursMinutes(it.data.movieInfoResponse.runtime)
        mViewBinding.tvBudgetFactMovieInfo.text=it.data.movieInfoResponse.budget.toString()
        mViewBinding.tvRevenueFactMovieInfo.text=it.data.movieInfoResponse.revenue.toString()
        mViewBinding.tvRevenueFactMovieInfo.text=it.data.movieInfoResponse.revenue.toString()

    }

    private fun setMedia(it: State.Success<MovieDetailsDisplay>){

        if(it.data.movieIMagesResponse.posters.size>0) {
            mViewBinding.ivPosterMovieInfo.load(IMAGE_BASE_URL_500 + it.data.movieIMagesResponse.posters.get(0).file_path)
            mViewBinding.tvNumberOfPosterMovieInfo.text = it.data.movieIMagesResponse.posters.size.toString() + " Posters"
        }
        if(it.data.movieIMagesResponse.backdrops.size>0) {
            mViewBinding.ivBackdropMovieInfo.load(IMAGE_BASE_URL_500 + it.data.movieIMagesResponse.backdrops.get(0).file_path)
            mViewBinding.tvNumberOfBackdropMovieInfo.text = it.data.movieIMagesResponse.backdrops.size.toString() + " Backdrops"
        }
    }

    private fun setProductionCompanies(it: State.Success<MovieDetailsDisplay>){
        var production_companies=""
        for (i in 1..(it.data.movieInfoResponse.production_companies.size-1 )) {
            production_companies+=it.data.movieInfoResponse.production_companies.get(i).name+", "
        }
        mViewBinding.tvProductionCompaniesMovieInfo.text=production_companies
    }

}