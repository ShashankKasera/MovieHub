package com.codeinglogs.presentation.model.movies.moviedetail.info

import com.codeinglogs.domain.model.movies.moviedetail.info.MovieGener as domainMovieGener
data class MovieGener(
    val id: Int,
    val name: String
)

fun domainMovieGener.toPresentationMovieGener()=MovieGener(
    id=id,
    name=name
)