package com.codeinglogs.moviedetails.ui.fragment

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviedetails.ui.adapter.GenresAdapter
import com.codeinglogs.moviedetails.ui.adapter.VideoAdapter
import com.codeinglogs.moviedetails.databinding.FragmentInfoBinding
import com.codeinglogs.moviedetails.ui.adapter.CrewAdapter
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.movies.moviedetail.MovieDetailsDisplay
import com.codeinglogs.presentation.viewmodel.moviedetail.MovieDetailViewModel


private const val TAG = "123InfoFragment"

class InfoFragment : BaseFragment<MovieDetailViewModel, FragmentInfoBinding>(){

    private lateinit var genresAdapter: GenresAdapter
    private lateinit var videoAdapter: VideoAdapter
    private lateinit var crewAdapter: CrewAdapter

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
        setUpGenresAdapter()

        genresAdapter.submitList(it.data.movieInfoResponse.genres)
    }

    private fun convertNumberToHoursMinutes(runtime:Int):kotlin.String{
        val hours = runtime / 60
        val mins = (runtime %  60)

        return "$hours Hours: $mins Minutes"
    }
    private fun setUpGenresAdapter() {
        genresAdapter = GenresAdapter()
        mViewBinding.rvMovieTypeMovieInfo.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvMovieTypeMovieInfo.adapter=this.genresAdapter


    }


    private  fun  setCrew(it: State.Success<MovieDetailsDisplay>) {

        setUpCrewAdapter()

        crewAdapter.submitList(it.data.movieCreditsResponse.crew)

        Log.i(TAG, "setCrew: ${it.data.movieCreditsResponse.crew}")
    }

    private fun setUpCrewAdapter() {
        crewAdapter = CrewAdapter()
        mViewBinding.rvCrewMovieInfo.layoutManager= GridLayoutManager(context,2)
        mViewBinding.rvCrewMovieInfo.adapter=this.crewAdapter


    }

    private fun setTrailer(it: State.Success<MovieDetailsDisplay>){

        setUpVideoAdapter()
        videoAdapter.submitList(it.data.MovieVideosResponse.results)

    }

    private fun setUpVideoAdapter() {
        videoAdapter = VideoAdapter()
        mViewBinding.rvVideoMovieInfo.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvVideoMovieInfo.adapter=this.videoAdapter
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
    override fun getViewBinding() = FragmentInfoBinding.inflate(layoutInflater)
}