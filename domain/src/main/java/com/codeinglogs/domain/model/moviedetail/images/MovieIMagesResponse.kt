package com.codeinglogs.domain.model.moviedetail.images


data class MovieIMagesResponse(
    val backdrops: List<MovieBackdrop>,
    val id: Int,
    val posters: List<MoviePoster>
)