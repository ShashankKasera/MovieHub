package com.codeinglogs.remote.model.tvshows.tvshowseasondetails.seasonimage
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasonimage.TvShowSeasonPoster as DataTvShowSeasonPoster

data class TvShowSeasonPoster(
    val aspect_ratio: Double?,
    val file_path: String?,
    val height: Int?,
    val iso_639_1: String?,
    val vote_average: Double?,
    val vote_count: Int?,
    val width: Int
)

fun TvShowSeasonPoster.toDataTvShowPoster()=DataTvShowSeasonPoster(
    file_path=file_path?:""
)