package com.codeinglogs.presentation.model.tvshow.tvshowdetails.reviews

import com.codeinglogs.domain.model.tvshow.tvshowdetails.reviews.TvShowReviews as DomainTvShowReviews

data class TvShowReviews(
    val author: String,
    val content: String,
)
fun DomainTvShowReviews.toPresentationTvShowReviews()= TvShowReviews(
    author=author,
    content=content
)