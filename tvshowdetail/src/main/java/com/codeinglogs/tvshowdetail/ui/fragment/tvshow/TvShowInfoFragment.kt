package com.codeinglogs.tvshowdetail.ui.fragment.tvshow

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.core.extension.load
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.TvShowDetailsDisplay
import com.codeinglogs.presentation.viewmodel.tvshowdetails.TvShowDetailViewModel
import com.codeinglogs.tvshowdetail.databinding.FragmentTvShowInfoBinding
import com.codeinglogs.tvshowdetail.ui.adapter.tvshow.TvShowCrewAdapter
import com.codeinglogs.tvshowdetail.ui.adapter.tvshow.TvShowGenresAdapter
import com.codeinglogs.tvshowdetail.ui.adapter.tvshowseason.TvShowSeasonsAdapter
import com.codeinglogs.tvshowdetail.ui.adapter.tvshow.TvShowVideoAdapter

class TvShowInfoFragment : BaseFragment<TvShowDetailViewModel, FragmentTvShowInfoBinding>(){

    private lateinit var tvShowGenresAdapter: TvShowGenresAdapter
    private lateinit var tvShowSeasonsAdapter: TvShowSeasonsAdapter
    private lateinit var tvShowVideoAdapter: TvShowVideoAdapter
    private lateinit var tvShowCrewAdapter: TvShowCrewAdapter
    override val mViewModel: TvShowDetailViewModel by activityViewModels()

    override fun getViewBinding() = FragmentTvShowInfoBinding.inflate(layoutInflater)


    override fun onBinding() {

        setUpTvShowDetail()
        setUpTvShowSeasonDetails()

    }
    private fun setUpTvShowDetail(){
        mViewModel.tvShowDetails.observe(this){
            it.peekContent().let{it ->
                when(it){
                    is State.Failed -> {
                        Log.i("wkjnv", "Failed: TvShowDetailActivity ${it.message}")
                        showProgressBar(false)
                    }
                    is State.Loading -> {
                        Log.i("wkjnv", "Loading: TvShowDetailActivity ${it.data}")
                        showProgressBar(true)
                    }
                    is State.Success -> {
                        Log.i("wkjnv", "Success: TvShowDetailActivity ${it.data}")

                        showProgressBar(false)

                        setDetails(it)
                        setCrew(it)
                        setUpSeasons(it)
                        setTrailer(it)
                        setFact(it)
                        setMedia(it)
                        setProductionCompanies(it)



                    }
                }
            }
        }
    }

    private fun setUpTvShowSeasonDetails(){
        mViewModel.tvShowDetails.observe(this){
            it.peekContent().let{it ->
                when(it){
                    is State.Failed -> {
                        Log.i("wkjnv", "Failed: TvShowDetailActivity ${it.message}")
                        showProgressBar(false)
                    }
                    is State.Loading -> {
                        Log.i("wkjnv", "Loading: TvShowDetailActivity ${it.data}")
                        showProgressBar(true)
                    }
                    is State.Success -> {
                        Log.i("wkjnv", "Success: TvShowDetailActivity ${it.data}")

                        showProgressBar(false)

                        setDetails(it)
                        setCrew(it)
                        setUpSeasons(it)
                        setTrailer(it)
                        setFact(it)
                        setMedia(it)
                        setProductionCompanies(it)



                    }
                }
            }
        }
    }
    private fun setDetails(it: State.Success<TvShowDetailsDisplay>){

        //mViewBinding.tvTimeTvShowInfo.text=convertNumberToHoursMinutes(it.data.tvShowInfoResponse.)
        mViewBinding.tvTvShowNameTvShowInfo.text=it.data.tvShowInfoResponse.name
        mViewBinding.tvDescriptionTvShowInfo.text=it.data.tvShowInfoResponse.overview

        if(it.data.tvShowInfoResponse.first_air_date.length>4)
            mViewBinding.tvYearTvShowInfo.text=it.data.tvShowInfoResponse.first_air_date.substring(0,4)
        else
            mViewBinding.tvYearTvShowInfo.text=it.data.tvShowInfoResponse.first_air_date
        setUpGenresAdapter()

        tvShowGenresAdapter.submitList(it.data.tvShowInfoResponse.genres)
    }
    private fun convertNumberToHoursMinutes(runtime:Int):kotlin.String{
        val hours = runtime / 60
        val mins = (runtime %  60)

        return "$hours Hours: $mins Minutes"
    }
    private fun setUpGenresAdapter() {
        tvShowGenresAdapter = TvShowGenresAdapter()
        mViewBinding.rvTvShowTypeTvShowInfo.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvTvShowTypeTvShowInfo.adapter=this.tvShowGenresAdapter


    }
    private  fun  setCrew(it: State.Success<TvShowDetailsDisplay>) {

        setUpCrewAdapter()

        tvShowCrewAdapter.submitList(it.data.tvShowCreditsResponse.crew)

        Log.i("wkjnv", "setCrew: ${it.data.tvShowCreditsResponse.crew}")
    }
    private fun setUpCrewAdapter() {
        tvShowCrewAdapter = TvShowCrewAdapter()
        mViewBinding.rvCrewTvShowInfo.layoutManager= GridLayoutManager(context,2)
        mViewBinding.rvCrewTvShowInfo.adapter=this.tvShowCrewAdapter


    }
    private fun setUpSeasons(it: State.Success<TvShowDetailsDisplay>){
        setUpSeasonsAdapter()
        tvShowSeasonsAdapter.submitList(it.data.tvShowInfoResponse.seasons)

    }
    private fun setUpSeasonsAdapter() {
        tvShowSeasonsAdapter = TvShowSeasonsAdapter()
        mViewBinding.rvSeasonsTvShowInfo.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvSeasonsTvShowInfo.adapter=this.tvShowSeasonsAdapter
    }
    private fun setTrailer(it: State.Success<TvShowDetailsDisplay>){

        setUpVideoAdapter()
        tvShowVideoAdapter.submitList(it.data.tvShowVideosResponse.results)

    }
    private fun setUpVideoAdapter() {
        tvShowVideoAdapter = TvShowVideoAdapter()
        mViewBinding.rvVideoTvShowInfo.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvVideoTvShowInfo.adapter=this.tvShowVideoAdapter
    }
    private fun setFact(it: State.Success<TvShowDetailsDisplay>){
        mViewBinding.tvTitleFactTvShowInfo.text=it.data.tvShowInfoResponse.name
        mViewBinding.tvStatusFactTvShowInfo.text=it.data.tvShowInfoResponse.status
        mViewBinding.tvReleaseDateFactTvShowInfo.text=it.data.tvShowInfoResponse.first_air_date
        mViewBinding.tvOriginalLanguageFactTvShowInfo.text=it.data.tvShowInfoResponse.original_language
        //mViewBinding.tvRuntimeFactTvShowInfo.text=convertNumberToHoursMinutes(it.data.tvShowInfoResponse.runtime)

    }
    private fun setMedia(it: State.Success<TvShowDetailsDisplay>){

        if(it.data.tvShowIMagesResponse.posters.size>0) {
            mViewBinding.ivPosterTvShowInfo.load(IMAGE_BASE_URL_500 + it.data.tvShowIMagesResponse.posters.get(0).file_path)
            mViewBinding.tvNumberOfPosterTvShowInfo.text = it.data.tvShowIMagesResponse.posters.size.toString() + " Posters"
        }
        if(it.data.tvShowIMagesResponse.backdrops.size>0) {
            mViewBinding.ivBackdropTvShowInfo.load(IMAGE_BASE_URL_500 + it.data.tvShowIMagesResponse.backdrops.get(0).file_path)
            mViewBinding.tvNumberOfBackdropTvShowInfo.text = it.data.tvShowIMagesResponse.backdrops.size.toString() + " Backdrops"
        }
    }
    private fun setProductionCompanies(it: State.Success<TvShowDetailsDisplay>){
        var production_companies=""
        for (i in 1..(it.data.tvShowInfoResponse.production_companies.size-1 )) {
            production_companies+=it.data.tvShowInfoResponse.production_companies.get(i).name+", "
        }
        mViewBinding.tvProductionCompaniesTvShowInfo.text=production_companies
    }

}