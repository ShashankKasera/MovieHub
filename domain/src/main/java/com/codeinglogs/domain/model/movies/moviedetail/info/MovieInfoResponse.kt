package com.codeinglogs.domain.model.movies.moviedetail.info

data class MovieInfoResponse(
    val backdrop_path: String,
    val belongs_to_collection: String,
    val budget: Int,
    val production_companies: List<MovieProductionCompanies>,
    val genres: List<MovieGener>,
    val homepage: String,
    val id: Int,

    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)