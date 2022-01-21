package com.codeinglogs.domain.model.tvshow.tvshowslist

data class TvShow(
    val id: Long,
    val name: String,
    val original_name: String,
    val overview: String,
    val first_air_date: String,
    val vote_average: Double,
    val poster_path: String,
    val backdrop_path: String,
)