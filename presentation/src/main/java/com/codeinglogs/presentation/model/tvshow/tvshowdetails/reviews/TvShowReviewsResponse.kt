package com.codeinglogs.presentation.model.tvshow.tvshowdetails.reviews

import com.codeinglogs.domain.model.tvshow.tvshowdetails.reviews.TvShowReviews as DomainTvShowReviews
import com.codeinglogs.domain.model.tvshow.tvshowdetails.reviews.TvShowReviewsResponse as DomainTvShowReviewsResponse

data class TvShowReviewsResponse(
    val id: Int,
    val page: Int,
    val results: List<TvShowReviews>,
    val total_pages: Int,
    val total_results: Int
)
fun DomainTvShowReviewsResponse.toPresentationTvShowReviewsResponse()= TvShowReviewsResponse(
    id =id,
    page =page,
    results =results.toPresentationTvShowReviews(),
    total_pages =total_pages,
    total_results =total_results
)

fun List<DomainTvShowReviews>.toPresentationTvShowReviews():List<TvShowReviews>{
    val list= mutableListOf<TvShowReviews>()
    this.forEach { list.add(it.toPresentationTvShowReviews()) }
    return list
}