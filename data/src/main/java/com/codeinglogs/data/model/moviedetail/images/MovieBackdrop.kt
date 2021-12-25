package com.codeinglogs.data.model.moviedetail.images

import com.codeinglogs.domain.model.moviedetail.images.MovieBackdrop as DomainMovieBackdrop

data class MovieBackdrop(
    val file_path: String,
    val vote_count: Int,
)

fun MovieBackdrop.toDomainMovieBackdrop()= DomainMovieBackdrop(
    file_path=file_path,
    vote_count=vote_count
)