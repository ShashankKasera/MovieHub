package com.codeinglogs.data.model.tvshow.tvshowdetails.reviews

import com.codeinglogs.domain.model.tvshow.tvshowdetails.reviews.TvShowReviews as DomainTvShowReviews

data class TvShowReviews(
    val id: String,
    val author: String,
    val content: String,
)

fun TvShowReviews.toDomainTvShowReviews()= DomainTvShowReviews(
    id=id,
    author=author,
    content=content
)