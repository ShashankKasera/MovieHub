package com.codeinglogs.remote.model.tvshows.tvshowdetails.video
import com.codeinglogs.data.model.tvshow.tvshowdetails.video.TvShowsVideos as DataTvShowsVideos


data class TvShowsVideos(
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


fun TvShowsVideos.toDataTvShowsVideos()=DataTvShowsVideos(
    id = id?:"",
    key = key?:"",
    name = name?:"",
)