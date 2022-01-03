package com.codeinglogs.data.model.tvshow.tvshowdetails.reviews

import com.codeinglogs.domain.model.tvshow.tvshowdetails.reviews.TvShowReviews as DomainTvShowReviews

data class TvShowReviews(
    val author: String,
    val content: String,
)

fun TvShowReviews.toDomainTvShowReviews()= DomainTvShowReviews(
    author=author,
    content=content
)