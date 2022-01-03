package com.codeinglogs.data.model.tvshow.tvshowdetails.reviews

import com.codeinglogs.domain.model.tvshow.tvshowdetails.reviews.TvShowReviews as DomainTvShowReviews
import com.codeinglogs.domain.model.tvshow.tvshowdetails.reviews.TvShowReviewsResponse as DomainTvShowReviewsResponse

data class TvShowReviewsResponse(
    val id: Int,
    val page: Int,
    val results: List<TvShowReviews>,
    val total_pages: Int,
    val total_results: Int
)

fun TvShowReviewsResponse.toDomainTvShowReviewsResponse()= DomainTvShowReviewsResponse(
    id =id,
    page =page,
    results =results.toDomainTvShowReviews(),
    total_pages =total_pages,
    total_results =total_results
)

fun List<TvShowReviews>.toDomainTvShowReviews():List<DomainTvShowReviews>{
    val list= mutableListOf<DomainTvShowReviews>()
    this.forEach { list.add(it.toDomainTvShowReviews()) }
    return list
}