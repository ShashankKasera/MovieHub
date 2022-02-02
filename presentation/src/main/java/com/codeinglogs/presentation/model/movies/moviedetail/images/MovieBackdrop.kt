package com.codeinglogs.presentation.model.movies.moviedetail.images

import com.codeinglogs.domain.model.movies.moviedetail.images.MovieBackdrop as DomainMovieBackdrop


data class MovieBackdrop(

    val file_path: String,
    val vote_count: Int,
)

fun DomainMovieBackdrop.toPresentationMovieBackdrop()= MovieBackdrop(

    file_path=file_path,
    vote_count=vote_count
)