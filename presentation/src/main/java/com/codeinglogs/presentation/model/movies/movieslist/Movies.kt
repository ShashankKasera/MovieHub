package com.codeinglogs.presentation.model.movies.movieslist

import com.codeinglogs.domain.model.movies.movieslist.Movies as DomainResult

data class Movies(
    val id: Double?,
    val poster_path: String?,
    val title: String?,
    val vote_average: Double?,
)

fun DomainResult.toPresentationMovies() = Movies(
    id = id,
    poster_path = poster_path,
    title =title,
    vote_average=vote_average
)

