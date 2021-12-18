package com.codeinglogs.remote.model.tvshows.tvshowslist

import com.codeinglogs.data.model.tvshow.tvshowlist.TvShow as DataTvShow

data class TvShows(
    val backdrop_path: String?,
    val first_air_date: String?,
    val genre_ids: List<Int>?,
    val id: Int?,
    val media_type: String?,
    val name: String?,
    val origin_country: List<String>?,
    val original_language: String?,
    val original_name: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val vote_average: Double?,
    val vote_count: Int?
)

fun TvShows.toDataTvShow()=DataTvShow(
    id=id?:0,
    name=name?:"",
    original_name=original_name?:"",
    overview=overview?:"",
    poster_path=poster_path?:"",
    vote_average=vote_average?:0.0

)

