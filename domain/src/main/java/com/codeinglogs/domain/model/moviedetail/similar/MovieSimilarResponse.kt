package com.codeinglogs.domain.model.moviedetail.similar


data class MovieSimilarResponse(
    val page: Int,
    val results: List<MovieSimilar>,
    val total_pages: Int,
    val total_results: Int
)