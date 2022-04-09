package com.codeinglogs.tvshowdetail.ui.fragment.tvshow

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinglogs.core.base.BaseFragment
import com.codeinglogs.core.extension.load
import com.codeinglogs.core.extension.showToast
import com.codeinglogs.moviehub.constant.IMAGE_BASE_URL_500
import com.codeinglogs.presentation.model.State
import com.codeinglogs.presentation.model.tvshow.tvshowdetails.TvShowDetailsDisplay
import com.codeinglogs.presentation.viewmodel.tvshowdetails.TvShowDetailViewModel
import com.codeinglogs.tvshowdetail.databinding.FragmentTvShowInfoBinding
import com.codeinglogs.tvshowdetail.ui.activity.TvShowAllCrewActivity
import com.codeinglogs.tvshowdetail.ui.adapter.tvshow.TvShowCrewAdapter
import com.codeinglogs.tvshowdetail.ui.adapter.tvshow.TvShowGenresAdapter
import com.codeinglogs.tvshowdetail.ui.adapter.tvshow.TvShowSeasonsAdapter
import com.codeinglogs.tvshowdetail.ui.adapter.tvshow.TvShowVideoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
@AndroidEntryPoint
class TvShowInfoFragment : BaseFragment<TvShowDetailViewModel, FragmentTvShowInfoBinding>(){

    private lateinit var tvShowGenresAdapter: TvShowGenresAdapter
    private lateinit var tvShowSeasonsAdapter: TvShowSeasonsAdapter
    private lateinit var tvShowVideoAdapter: TvShowVideoAdapter
    private lateinit var tvShowCrewAdapter: TvShowCrewAdapter

    override val mViewModel: TvShowDetailViewModel by activityViewModels()
    override fun getViewBinding() = FragmentTvShowInfoBinding.inflate(layoutInflater)

    override fun onBinding() {

        init()
        tvShowDetailObserve()
    }

    private fun init(){
        initProgressBar(mViewBinding.tvshowDetailLoader)
        setUpGenresAdapter()
        setUpCrewAdapter()
        setUpSeasonsAdapter()
        setUpVideoAdapter()
    }

    private fun tvShowDetailObserve(){
        mViewModel.tvShowDetails.observe(this){
            it.peekContent().let{it ->
                when(it){
                    is State.Failed -> {
                        Log.i("wkjnv", "Failed: TvShowDetailActivity ${it.message}")
                        showProgressBar(false)
                        showToast(it.message)
                    }
                    is State.Loading -> {
                        Log.i("wkjnv", "Loading: TvShowDetailActivity ${it.data}")
                        if(it.data!=null&&it.data?.tvShowCreditsResponse?.crew?.isNotEmpty() == true){
                            setDetails(it.data!!)
                            setCrew(it.data!!)
                            setSeasons(it.data!!)
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
                        Log.i("wkjnv", "Success: TvShowDetailActivity ${it.data}")

                        lifecycleScope.launch(Dispatchers.Main) {
                            showProgressBar(false)
                            setDetails(it.data)
                            setCrew(it.data)
                            setTrailer(it.data)
                            setFact(it.data)
                            setMedia(it.data)
                            setProductionCompanies(it.data)

                            mViewBinding.tvShowAllTvShowInfo.setOnClickListener(){
                                startActivity(TvShowAllCrewActivity.getInstance(requireContext(),mViewModel.tvShowId))
                            }
                        }
                    }
                }
            }
        }
    }

    private fun setDetails(it: TvShowDetailsDisplay){

        //mViewBinding.tvTimeTvShowInfo.text=convertNumberToHoursMinutes(it.data.tvShowInfoResponse.)
        mViewBinding.tvTvShowNameTvShowInfo.text=it.tvShowInfoResponse.name
        mViewBinding.tvDescriptionTvShowInfo.text=it.tvShowInfoResponse.overview

        if(it.tvShowInfoResponse.first_air_date.length>4)
            mViewBinding.tvYearTvShowInfo.text=it.tvShowInfoResponse.first_air_date.substring(0,4)
        else
            mViewBinding.tvYearTvShowInfo.text=it.tvShowInfoResponse.first_air_date

        tvShowGenresAdapter.submitList(it.tvShowInfoResponse.genres)
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

    private fun setCrew(it: TvShowDetailsDisplay) {

        setUpCrewAdapter()

        tvShowCrewAdapter.submitList(it.tvShowCreditsResponse.crew)

        Log.i("wkjnv", "setCrew: ${it.tvShowCreditsResponse.crew}")
    }

    private fun setUpCrewAdapter() {
        tvShowCrewAdapter = TvShowCrewAdapter()
        mViewBinding.rvCrewTvShowInfo.layoutManager= GridLayoutManager(context,2)
        mViewBinding.rvCrewTvShowInfo.adapter=this.tvShowCrewAdapter


    }

    private fun setSeasons(it: TvShowDetailsDisplay){
        tvShowSeasonsAdapter.submitList(it.tvShowInfoResponse.seasons)

    }

    private fun setUpSeasonsAdapter() {
        tvShowSeasonsAdapter = TvShowSeasonsAdapter(mViewModel.tvShowId)
        mViewBinding.rvSeasonsTvShowInfo.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvSeasonsTvShowInfo.adapter=this.tvShowSeasonsAdapter
    }

    private fun setTrailer(it: TvShowDetailsDisplay){
        tvShowVideoAdapter.submitList(it.tvShowVideosResponse.results)

    }

    private fun setUpVideoAdapter() {
        tvShowVideoAdapter = TvShowVideoAdapter()
        mViewBinding.rvVideoTvShowInfo.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)
        mViewBinding.rvVideoTvShowInfo.adapter=this.tvShowVideoAdapter
    }

    private fun setFact(it: TvShowDetailsDisplay){
        mViewBinding.tvTitleFactTvShowInfo.text=it.tvShowInfoResponse.name
        mViewBinding.tvStatusFactTvShowInfo.text=it.tvShowInfoResponse.status
        mViewBinding.tvReleaseDateFactTvShowInfo.text=it.tvShowInfoResponse.first_air_date
        mViewBinding.tvOriginalLanguageFactTvShowInfo.text=it.tvShowInfoResponse.original_language
        //mViewBinding.tvRuntimeFactTvShowInfo.text=convertNumberToHoursMinutes(it.tvShowInfoResponse.runtime)

    }

    private fun setMedia(it: TvShowDetailsDisplay){

        if(it.tvShowIMagesResponse.posters.size>0) {
            mViewBinding.ivPosterTvShowInfo.load(IMAGE_BASE_URL_500 + it.tvShowIMagesResponse.posters.get(0).file_path)
            mViewBinding.tvNumberOfPosterTvShowInfo.text = it.tvShowIMagesResponse.posters.size.toString() + " Posters"
        }
        if(it.tvShowIMagesResponse.backdrops.size>0) {
            mViewBinding.ivBackdropTvShowInfo.load(IMAGE_BASE_URL_500 + it.tvShowIMagesResponse.backdrops.get(0).file_path)
            mViewBinding.tvNumberOfBackdropTvShowInfo.text = it.tvShowIMagesResponse.backdrops.size.toString() + " Backdrops"
        }
    }

    private fun setProductionCompanies(it: TvShowDetailsDisplay){
        var production_companies=""
        for (i in 1..(it.tvShowInfoResponse.production_companies.size-1 )) {
            production_companies+=it.tvShowInfoResponse.production_companies.get(i).name+", "
        }
        mViewBinding.tvProductionCompaniesTvShowInfo.text=production_companies
    }

}