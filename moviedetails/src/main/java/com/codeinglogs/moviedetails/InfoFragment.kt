package com.codeinglogs.moviedetails

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviedetails.adapter.GenresAdapter
import com.codeinglogs.moviedetails.databinding.FragmentInfoBinding
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.moviedetail.MovieDetailsDisplay
import com.codeinglogs.presentation.viewmodel.moviedetail.MovieDetailViewModel
private const val TAG = "123InfoFragment"

class InfoFragment : BaseFragment<MovieDetailViewModel, FragmentInfoBinding>(){

    private lateinit var genresAdapter: GenresAdapter

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
                        setFact(it)
                        setMedia(it)

                    }
                }
            }
        }
    }

    private fun setDetails(it: State.Success<MovieDetailsDisplay>){



        mViewBinding.tvMovieNameMovieInfo.text=it.data.movieInfoResponse.title
        mViewBinding.tvDescriptionMovieInfo.text=it.data.movieInfoResponse.overview
        setUpGenresAdapter()
        genresAdapter.submitList(it.data?.movieInfoResponse?.genres)
    }

    private fun setUpGenresAdapter() {
        genresAdapter = GenresAdapter()
        mViewBinding.rvMovieTypeMovieInfo.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvMovieTypeMovieInfo.adapter=this.genresAdapter


    }

    private  fun  setCrew(it: State.Success<MovieDetailsDisplay>) {

        mViewBinding.tv1CrewMovieInfo.text=it.data.movieCreditsResponse.crew.get(0).name
        mViewBinding.tv1SubCrewMovieInfo.text=it.data.movieCreditsResponse.crew.get(0).known_for_department

        mViewBinding.tv2CrewMovieInfo.text=it.data.movieCreditsResponse.crew.get(1).name
        mViewBinding.tv2SubCrewMovieInfo.text=it.data.movieCreditsResponse.crew.get(1).known_for_department

        mViewBinding.tv3CrewMovieInfo.text=it.data.movieCreditsResponse.crew.get(2).name
        mViewBinding.tv3SubCrewMovieInfo.text=it.data.movieCreditsResponse.crew.get(2).known_for_department

        mViewBinding.tv4CrewMovieInfo.text=it.data.movieCreditsResponse.crew.get(3).name
        mViewBinding.tv4SubCrewMovieInfo.text=it.data.movieCreditsResponse.crew.get(3).known_for_department

        mViewBinding.tv5CrewMovieInfo.text=it.data.movieCreditsResponse.crew.get(4).name
        mViewBinding.tv5SubCrewMovieInfo.text=it.data.movieCreditsResponse.crew.get(4).known_for_department

        mViewBinding.tv6CrewMovieInfo.text=it.data.movieCreditsResponse.crew.get(5).name
        mViewBinding.tv6SubCrewMovieInfo.text=it.data.movieCreditsResponse.crew.get(5).known_for_department

        mViewBinding.tv7CrewMovieInfo.text=it.data.movieCreditsResponse.crew.get(6).name
        mViewBinding.tv7SubCrewMovieInfo.text=it.data.movieCreditsResponse.crew.get(6).known_for_department

        mViewBinding.tv8CrewMovieInfo.text=it.data.movieCreditsResponse.crew.get(7).name
        mViewBinding.tv8SubCrewMovieInfo.text=it.data.movieCreditsResponse.crew.get(7).known_for_department

    }

    private fun setFact(it: State.Success<MovieDetailsDisplay>){
        mViewBinding.tvTitleFactMovieInfo.text=it.data.movieInfoResponse.title
        mViewBinding.tvStatusFactMovieInfo.text=it.data.movieInfoResponse.status
        mViewBinding.tvReleaseDateFactMovieInfo.text=it.data.movieInfoResponse.release_date
        mViewBinding.tvOriginalLanguageFactMovieInfo.text=it.data.movieInfoResponse.original_language
        mViewBinding.tvBudgetFactMovieInfo.text=it.data.movieInfoResponse.budget.toString()
        mViewBinding.tvRevenueFactMovieInfo.text=it.data.movieInfoResponse.revenue.toString()
        mViewBinding.tvRevenueFactMovieInfo.text=it.data.movieInfoResponse.revenue.toString()

    }

    private fun setMedia(it: State.Success<MovieDetailsDisplay>){
        mViewBinding.ivPosterMovieInfo.load(IMAGE_BASE_URL_500+it.data.movieIMagesResponse.posters.get(0).file_path)
        mViewBinding.tvNumberOfPosterMovieInfo.text=it.data.movieIMagesResponse.posters.size.toString()

        mViewBinding.ivBackdropMovieInfo.load(IMAGE_BASE_URL_500+it.data.movieIMagesResponse.backdrops.get(0).file_path)
        mViewBinding.tvNumberOfBackdropMovieInfo.text=it.data.movieIMagesResponse.backdrops.size.toString()

    }
    override fun getViewBinding() = FragmentInfoBinding.inflate(layoutInflater)


}