package com.codeinglogs.remote.model.tvshows.tvshowdetails.image

import com.codeinglogs.data.model.tvshow.tvshowdetails.image.TvShowBackdrop as DataTvShowBackdrop

data class TvShowBackdrop(
    val aspect_ratio: Double?,
    val file_path: String?,
    val height: Int?,
    val iso_639_1: Any?,
    val vote_average: Double?,
    val vote_count: Int?,
    val width: Int?
)

fun TvShowBackdrop.toDataTvShowBackdrop()=DataTvShowBackdrop(
    file_path=file_path?:"",
    vote_count=vote_count?:0
)