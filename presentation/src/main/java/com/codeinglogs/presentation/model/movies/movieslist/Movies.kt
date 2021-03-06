package com.codeinglogs.presentation.model.movies.movieslist

import com.codeinglogs.domain.model.movies.movieslist.Movies as DomainResult

data class Movies(
    val id: Long,
    val poster_path: String,
    val backdrop_path: String,
    val title: String,
    val release_date: String,
    val vote_average: Double,
)

fun DomainResult.toPresentationMovies() = Movies(
    id = id,
    poster_path = poster_path,
    backdrop_path = backdrop_path,
    title =title,
    release_date =release_date,
    vote_average=vote_average
)

