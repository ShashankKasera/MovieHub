package com.codeinglogs.remote.model.tvshows.tvshowdetails.credits

import com.codeinglogs.data.model.tvshow.tvshowdetails.credits.TvShowCast as DataTvShowCast
import com.codeinglogs.data.model.tvshow.tvshowdetails.credits.TvShowCrew as DataTvShowCrew
import com.codeinglogs.data.model.tvshow.tvshowdetails.credits.TvShowCreditsResponse as DataTvShowCreditsResponse


data class TvShowCreditsResponse(
    val cast: List<TvShowCast>?,
    val crew: List<TvShowCrew>?,
    val id: Int?
)

fun TvShowCreditsResponse.toDataTvShowCreditsResponse()=DataTvShowCreditsResponse(
    cast=cast?.toDataTvShowCast()?: listOf(),
    crew=crew?.toDataTvShowCrew()?: listOf(),
    id=id?:0
)

fun List<TvShowCast>.toDataTvShowCast():List<DataTvShowCast>{
    val list= mutableListOf<DataTvShowCast>()
    this.forEach { list.add(it.toDataTvShowCast()) }
    return list
}

fun List<TvShowCrew>.toDataTvShowCrew():List<DataTvShowCrew>{
    val list= mutableListOf<DataTvShowCrew>()
    this.forEach { list.add(it.toDataTvShowCrew()) }
    return list
}