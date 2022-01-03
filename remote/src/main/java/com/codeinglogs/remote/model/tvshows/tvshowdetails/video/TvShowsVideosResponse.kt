package com.codeinglogs.remote.model.tvshows.tvshowdetails.video

import com.codeinglogs.data.model.tvshow.tvshowdetails.video.TvShowsVideos as DataTvShowsVideos
import com.codeinglogs.data.model.tvshow.tvshowdetails.video.TvShowsVideosResponse as DataTvShowsVideosResponse

data class TvShowsVideosResponse(
    val id: Int?,
    val results: List<TvShowsVideos>?
)

fun TvShowsVideosResponse.toDataTvShowsVideosResponse()=DataTvShowsVideosResponse(
    id=id?:0,
    results = results?.toDataTvShowsVideos()?: listOf()
)

fun List<TvShowsVideos>.toDataTvShowsVideos():List<DataTvShowsVideos>{
    val list= mutableListOf<DataTvShowsVideos>()
    this.forEach { list.add(it.toDataTvShowsVideos()) }
    return list
}