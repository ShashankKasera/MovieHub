package com.codeinglogs.remote.model.tvshows.tvshowdetails.reviews
import com.codeinglogs.data.model.tvshow.tvshowdetails.reviews.TvShowReviews as DataTvShowReviews

data class TvShowReviews(
    val author: String?,
    val author_details: TvShowAuthorDetails?,
    val content: String?,
    val created_at: String?,
    val id: String?,
    val updated_at: String?,
    val url: String
)

fun TvShowReviews.toDataTvShowReviews()=DataTvShowReviews(
    author=author?:"",
    content=content?:""
)