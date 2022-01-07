package com.codeinglogs.remote.model.tvshows.tvshowdetails.image

import com.codeinglogs.data.model.tvshow.tvshowdetails.image.TvShowPoster as DataTvShowPoster

data class TvShowPoster(
    val aspect_ratio: Double?,
    val file_path: String?,
    val height: Int?,
    val iso_639_1: String?,
    val vote_average: Double?,
    val vote_count: Int?,
    val width: Int
)

fun TvShowPoster.toDataTvShowPoster()=DataTvShowPoster(
    file_path=file_path?:""
)