package com.codeinglogs.remote.model.tvshows.tvshowseasondetails.seasonimage

import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasonimage.TvShowSeasonPoster as DataTvShowSeasonPoster
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasonimage.TvShowSeasonImageResponse as DataTvShowSeasonImageResponse

data class TvShowSeasonImageResponse(
    val id: Int?,
    val posters: List<TvShowSeasonPoster>?
)

fun TvShowSeasonImageResponse.toDataTvShowSeasonImageResponse()=DataTvShowSeasonImageResponse(
    id=id?:0,
    posters = posters?.toDataTvShowSeasonPoster()?:listOf()
)


fun List<TvShowSeasonPoster>.toDataTvShowSeasonPoster():List<DataTvShowSeasonPoster>{
    val list= mutableListOf<DataTvShowSeasonPoster>()
    this.forEach { list.add(it.toDataTvShowPoster()) }
    return list
}