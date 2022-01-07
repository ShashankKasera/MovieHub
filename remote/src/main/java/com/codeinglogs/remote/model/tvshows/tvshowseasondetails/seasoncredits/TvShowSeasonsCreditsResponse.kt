package com.codeinglogs.remote.model.tvshows.tvshowseasondetails.seasoncredits

import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasoncredits.TvShowSeasonsCrew as DataTvShowSeasonsCrew
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasoncredits.TvShowSeasonsCast as DataTvShowSeasonsCast
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasoncredits.TvShowSeasonsCreditsResponse as DataTvShowSeasonsCreditsResponse

data class TvShowSeasonsCreditsResponse(
    val cast: List<TvShowSeasonsCast>?,
    val crew: List<TvShowSeasonsCrew>?,
    val id: Int?
)

fun TvShowSeasonsCreditsResponse.toDataTvShowSeasonsCreditsResponse()=DataTvShowSeasonsCreditsResponse(
    cast=cast?.toDataTvShowSeasonsCast()?: listOf(),
    crew=crew?.toDataTvShowSeasonsCrew()?: listOf(),
    id=id?:0
)

fun List<TvShowSeasonsCrew>.toDataTvShowSeasonsCrew():List<DataTvShowSeasonsCrew>{
    val list= mutableListOf<DataTvShowSeasonsCrew>()
    this.forEach { list.add(it.toDataTvShowSeasonsCrew()) }
    return list
}

fun List<TvShowSeasonsCast>.toDataTvShowSeasonsCast():List<DataTvShowSeasonsCast>{
    val list= mutableListOf<DataTvShowSeasonsCast>()
    this.forEach { list.add(it.toDataTvShowSeasonsCast()) }
    return list
}

