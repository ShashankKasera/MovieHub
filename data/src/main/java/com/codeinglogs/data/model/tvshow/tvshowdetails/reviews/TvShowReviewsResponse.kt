package com.codeinglogs.data.model.tvshow.tvshowdetails.reviews

import com.codeinglogs.domain.model.tvshow.tvshowdetails.reviews.TvShowReviews as DomainTvShowReviews
import com.codeinglogs.domain.model.tvshow.tvshowdetails.reviews.TvShowReviewsResponse as DomainTvShowReviewsResponse

data class TvShowReviewsResponse(
    val id: Int,
    val results: List<TvShowReviews>,
)

fun TvShowReviewsResponse.toDomainTvShowReviewsResponse()= DomainTvShowReviewsResponse(
    id =id,
    results =results.toDomainTvShowReviews()
)

fun List<TvShowReviews>.toDomainTvShowReviews():List<DomainTvShowReviews>{
    val list= mutableListOf<DomainTvShowReviews>()
    this.forEach { list.add(it.toDomainTvShowReviews()) }
    return list
}