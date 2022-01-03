package com.codeinglogs.remote.model.tvshows.tvshowdetails.reviews

import com.codeinglogs.data.model.tvshow.tvshowdetails.reviews.TvShowReviews as DataTvShowReviews
import com.codeinglogs.data.model.tvshow.tvshowdetails.reviews.TvShowReviewsResponse as DataTvShowReviewsResponse

data class TvShowReviewsResponse(
    val id: Int?,
    val page: Int?,
    val results: List<TvShowReviews>?,
    val total_pages: Int?,
    val total_results: Int?
)

fun TvShowReviewsResponse.toDataTvShowReviewsResponse()=DataTvShowReviewsResponse(
    id =id?:0,
    page =page?:0,
    results =results?.toDataTvShowReviews()?: listOf(),
    total_pages =total_pages?:0,
    total_results =total_results?:0
)

fun List<TvShowReviews>.toDataTvShowReviews():List<DataTvShowReviews>{
    val list= mutableListOf<DataTvShowReviews>()
    this.forEach { list.add(it.toDataTvShowReviews()) }
    return list
}