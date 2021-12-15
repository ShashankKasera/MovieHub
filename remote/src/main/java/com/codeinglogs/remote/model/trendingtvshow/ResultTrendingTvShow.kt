package com.codeinglogs.remote.model.trendingtvshow

import com.codeinglogs.data.model.trendingtvshow.ResultTrendingTvShow as DataResultTrendingTvShow

data class ResultTrendingTvShow(
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

fun ResultTrendingTvShow.toDataTrendingTvShowResult()=DataResultTrendingTvShow(
    id=id?:0,
    media_type=media_type?:"",
    name=name?:"",
    origin_country=origin_country?:listOf(),
    original_language=original_language?:"",
    original_name=original_name?:"",
    overview=overview?:"",
    popularity=popularity?:0.0
)

