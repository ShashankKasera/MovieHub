package com.codeinglogs.domain.model.trendingtvshow

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