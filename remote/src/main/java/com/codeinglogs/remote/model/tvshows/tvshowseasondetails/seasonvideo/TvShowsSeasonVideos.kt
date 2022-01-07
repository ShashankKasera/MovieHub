package com.codeinglogs.remote.model.tvshows.tvshowseasondetails.seasonvideo
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasonvideo.TvShowsSeasonVideos as DataTvShowsSeasonVideos

data class TvShowsSeasonVideos(
    val id: String?,
    val iso_3166_1: String?,
    val iso_639_1: String?,
    val key: String?,
    val name: String?,
    val official: Boolean?,
    val published_at: String?,
    val site: String?,
    val size: Int?,
    val type: String?
)

fun TvShowsSeasonVideos.toDataTvShowsSeasonVideos()=DataTvShowsSeasonVideos(
    id = id?:"",
    key = key?:"",
    name = name?:"",
)