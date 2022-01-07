package com.codeinglogs.remote.model.tvshows.tvshowseasondetails.seasonvideo

import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasonvideo.TvShowsSeasonVideos as DataTvShowsSeasonVideos
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasonvideo.TvShowsSeasonVideosResponse as DataTvShowsSeasonVideosResponse

data class TvShowsSeasonVideosResponse(
    val id: Int?,
    val results: List<TvShowsSeasonVideos>?
)

fun TvShowsSeasonVideosResponse.toDataTvShowsSeasonVideosResponse()=DataTvShowsSeasonVideosResponse(
    id=id?:0,
    results = results?.toDataTvShowsSeasonVideos()?: listOf()
)

fun List<TvShowsSeasonVideos>.toDataTvShowsSeasonVideos():List<DataTvShowsSeasonVideos>{
    val list= mutableListOf<DataTvShowsSeasonVideos>()
    this.forEach { list.add(it.toDataTvShowsSeasonVideos()) }
    return list
}