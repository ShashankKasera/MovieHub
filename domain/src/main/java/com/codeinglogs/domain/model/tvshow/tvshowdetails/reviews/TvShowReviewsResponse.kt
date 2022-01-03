package com.codeinglogs.domain.model.tvshow.tvshowdetails.reviews

data class TvShowReviewsResponse(
    val id: Int,
    val page: Int,
    val results: List<TvShowReviews>,
    val total_pages: Int,
    val total_results: Int
)