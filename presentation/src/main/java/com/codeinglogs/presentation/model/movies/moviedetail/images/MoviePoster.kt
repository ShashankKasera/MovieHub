package com.codeinglogs.presentation.model.movies.moviedetail.images

import com.codeinglogs.domain.model.movies.moviedetail.images.MoviePoster as DomainMoviePoster


data class MoviePoster(
    val file_path: String,
    val vote_count: Int,
)

fun DomainMoviePoster.toPresentationMoviePoster()= MoviePoster(
    file_path = file_path,
    vote_count = vote_count
)