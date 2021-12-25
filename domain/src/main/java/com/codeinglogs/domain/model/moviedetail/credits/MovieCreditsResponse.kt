package com.codeinglogs.domain.model.moviedetail.credits

data class MovieCreditsResponse(
    val cast: List<Cast>,
    val crew: List<Crew>,
    val id: Int
)