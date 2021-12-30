package com.codeinglogs.data.model.movies.moviedetail.info

import com.codeinglogs.domain.model.movies.moviedetail.info.MovieGener as DomainMovieGener
data class MovieGener(
    val id: Int,
    val name: String
)

fun MovieGener.toDomainMovieGener()=DomainMovieGener(
    id=id,
    name=name
)