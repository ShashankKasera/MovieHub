package com.codeinglogs.domain.model.movies.moviedetail.info

data class MovieInfoResponse(
    val backdrop_path: String,
    val budget: Int,
    val production_companies: List<MovieProductionCompanies>,
    val genres: List<MovieGener>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val status: String,
    val title: String,
    val vote_average: Double,
)