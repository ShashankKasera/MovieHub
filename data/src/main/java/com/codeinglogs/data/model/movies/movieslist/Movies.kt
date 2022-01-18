package com.codeinglogs.data.model.movies.movieslist

import com.codeinglogs.domain.model.movies.movieslist.Movies as DomainMovies

data class Movies(
    val id: Long,
    val poster_path: String,
    val title: String,
    val release_date: String,
    val vote_average: Double,
)

fun Movies.toDomainMovies() = DomainMovies(
    id = id,
    poster_path = poster_path,
    title =title,
    release_date =release_date,
    vote_average=vote_average
)


