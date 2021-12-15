package com.codeinglogs.data.model.trendingtvshow

import com.codeinglogs.domain.model.trendingtvshow.ResultTrendingTvShow as DomainResultTrendingTvShow

data class ResultTrendingTvShow(

    val id: Int,
    val media_type: String,
    val name: String,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
)

fun ResultTrendingTvShow.toDomainTrendingTvShowResult()=DomainResultTrendingTvShow(
    id=id,
    media_type=media_type,
    name=name,
    origin_country=origin_country,
    original_language=original_language,
    original_name=original_name,
    overview=overview,
    popularity=popularity,
)