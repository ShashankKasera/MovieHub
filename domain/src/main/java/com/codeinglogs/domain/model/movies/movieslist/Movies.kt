package com.codeinglogs.domain.model.movies.movieslist

data class Movies(
    val id: Long,
    val title: String,
    val poster_path: String,
    val release_date: String,
    val vote_average: Double,
)