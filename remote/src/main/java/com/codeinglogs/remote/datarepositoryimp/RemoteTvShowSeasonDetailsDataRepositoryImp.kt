package com.codeinglogs.remote.datarepositoryimp

import android.util.Log
import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.TvShowSeasonDetailsDisplay
import com.codeinglogs.data.repository.tvshowseasondetails.RemoteTvShowSeasonDetailsData
import com.codeinglogs.remote.model.tvshows.tvshowseasondetails.seasoncredits.toDataTvShowSeasonsCreditsResponse
import com.codeinglogs.remote.model.tvshows.tvshowseasondetails.seasonimage.toDataTvShowSeasonImageResponse
import com.codeinglogs.remote.model.tvshows.tvshowseasondetails.seasons.toDataTvShowSeasonsResponse
import com.codeinglogs.remote.model.tvshows.tvshowseasondetails.seasonvideo.toDataTvShowsSeasonVideosResponse
import com.codeinglogs.remote.request.TvShowRequest
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteTvShowSeasonDetailsDataRepositoryImp @Inject constructor (private val tvShowRequest: TvShowRequest) :
    RemoteTvShowSeasonDetailsData {


    override fun getTvShowSeasonDetails(
        id: String,
        season_number: Int
    )=flow <State<TvShowSeasonDetailsDisplay>>{
        emit(State.loading())
        val data = coroutineScope{

            val tvShowSeasonInfo = async { tvShowRequest.getTvShowSeason(id,season_number)}
            val tvShowSeasonCredits = async { tvShowRequest.getTvShowSeasonCredits(id,season_number)}
            val tvShowSeasonImage = async { tvShowRequest.getTvShowSeasonImages(id,season_number)}
            val tvShowSeasonVideo = async { tvShowRequest.getTvShowSeasonVideos(id,season_number)}

            Log.i("jfwjkwgn", "getTvShowSeasonDetails: ${tvShowSeasonInfo.await()}")
            Log.i("jfwjkwgn", "getTvShowSeasonDetails: ${tvShowSeasonCredits}")
            Log.i("jfwjkwgn", "getTvShowSeasonDetails: ${tvShowSeasonImage}")
            Log.i("jfwjkwgn", "getTvShowSeasonDetails: ${tvShowSeasonVideo}")
            TvShowSeasonDetailsDisplay(
                tvShowSeasonCredits.await().toDataTvShowSeasonsCreditsResponse(),
                tvShowSeasonInfo.await().toDataTvShowSeasonsResponse(),
                tvShowSeasonImage.await().toDataTvShowSeasonImageResponse(),
                tvShowSeasonVideo.await().toDataTvShowsSeasonVideosResponse(),
                )
        }
        emit(State.success(data))
    }.catch {
        emit(State.failed(it.message?:""))
    }

}