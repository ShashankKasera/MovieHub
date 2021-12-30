package com.codeinglogs.domain.model.movies.moviedetail.reviews

data class MovieReviewsResponse(
    val id: Int,
    val page: Int,
    val results: List<MovieReviews>,
    val total_pages: Int,
    val total_results: Int
)