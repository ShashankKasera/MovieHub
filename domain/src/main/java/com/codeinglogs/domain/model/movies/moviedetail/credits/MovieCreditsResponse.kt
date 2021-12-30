package com.codeinglogs.domain.model.movies.moviedetail.credits

data class MovieCreditsResponse(
    val cast: List<MovieCast>,
    val crew: List<MovieCrew>,
    val id: Int
)