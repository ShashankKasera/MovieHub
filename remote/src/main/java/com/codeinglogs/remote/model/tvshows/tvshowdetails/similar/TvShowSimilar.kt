package com.codeinglogs.remote.model.tvshows.tvshowdetails.similar
import com.codeinglogs.data.model.tvshow.tvshowdetails.similar.TvShowSimilar as DataTvShowSimilar

data class TvShowSimilar(
    val adult: Boolean?,
    val backdrop_path: String?,
    val first_air_date: String?,
    val genre_ids: List<Int>?,
    val id: Int?,
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

fun TvShowSimilar.toDataTvShowSimilar()=DataTvShowSimilar(
    backdrop_path=backdrop_path?:"",
    first_air_date=first_air_date?:"",
    id=id?:0,
    name=name?:"",
    vote_average=vote_average?:0.0
)