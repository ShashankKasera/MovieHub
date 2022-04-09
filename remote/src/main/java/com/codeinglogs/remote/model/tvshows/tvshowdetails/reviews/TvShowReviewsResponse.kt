package com.codeinglogs.remote.model.tvshows.tvshowdetails.reviews

import com.codeinglogs.data.model.tvshow.tvshowdetails.reviews.TvShowReviews as DataTvShowReviews
import com.codeinglogs.data.model.tvshow.tvshowdetails.reviews.TvShowReviewsResponse as DataTvShowReviewsResponse

data class TvShowReviewsResponse(
    val id: Int?,
    val results: List<TvShowReviews>?,
)

fun TvShowReviewsResponse.toDataTvShowReviewsResponse()=DataTvShowReviewsResponse(
    id =id?:0,
    results =results?.toDataTvShowReviews()?: listOf(),
)

fun List<TvShowReviews>.toDataTvShowReviews():List<DataTvShowReviews>{
    val list= mutableListOf<DataTvShowReviews>()
    this.forEach { list.add(it.toDataTvShowReviews()) }
    return list
}