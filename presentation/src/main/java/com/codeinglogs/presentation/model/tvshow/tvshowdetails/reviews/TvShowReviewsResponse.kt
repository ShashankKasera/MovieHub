package com.codeinglogs.presentation.model.tvshow.tvshowdetails.reviews

import com.codeinglogs.domain.model.tvshow.tvshowdetails.reviews.TvShowReviews as DomainTvShowReviews
import com.codeinglogs.domain.model.tvshow.tvshowdetails.reviews.TvShowReviewsResponse as DomainTvShowReviewsResponse

data class TvShowReviewsResponse(
    val id: Int,
    val results: List<TvShowReviews>,
)
fun DomainTvShowReviewsResponse.toPresentationTvShowReviewsResponse()= TvShowReviewsResponse(
    id =id,
    results =results.toPresentationTvShowReviews(),
)

fun List<DomainTvShowReviews>.toPresentationTvShowReviews():List<TvShowReviews>{
    val list= mutableListOf<TvShowReviews>()
    this.forEach { list.add(it.toPresentationTvShowReviews()) }
    return list
}