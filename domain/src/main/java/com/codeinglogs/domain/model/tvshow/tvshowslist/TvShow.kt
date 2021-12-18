package com.codeinglogs.domain.model.tvshow.tvshowslist

data class TvShow(
    val id: Int,
    val name: String,
    val original_name: String,
    val overview: String,
    val vote_average: Double,
    val poster_path: String,
)