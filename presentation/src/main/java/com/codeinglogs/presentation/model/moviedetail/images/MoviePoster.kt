package com.codeinglogs.presentation.model.moviedetail.images

import com.codeinglogs.domain.model.moviedetail.images.MoviePoster as DomainMoviePoster


data class MoviePoster(
    val file_path: String,
    val vote_count: Int,
)

fun DomainMoviePoster.toPresentationMoviePoster()= MoviePoster(
    file_path = file_path,
    vote_count = vote_count
)