package com.codeinglogs.domain.model.moviedetail.similar

data class MovieSimilar(
    val id: Int,
    val original_title: String,
    val poster_path: String,
    val title: String,
    val release_date: String,
    val vote_average: Double,
)