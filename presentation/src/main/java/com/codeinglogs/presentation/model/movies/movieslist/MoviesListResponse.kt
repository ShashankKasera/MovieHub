package com.codeinglogs.presentation.model.movies.movieslist

import com.codeinglogs.domain.model.movies.movieslist.MoviesListResponse as DomainMoviesListResponse
import com.codeinglogs.domain.model.movies.movieslist.Movies as DomainMovies

data class MoviesListResponse(
    val page: Int?,
    val results: List<Movies>?,
    val total_pages: Int?,
    val total_results: Int?
)

fun DomainMoviesListResponse.toPresentationMoviesListResponse() =
    MoviesListResponse(
        page = page,
        total_pages = total_pages,
        total_results = total_results,
        results = results?.toPresentationMovies()
    )

fun List<DomainMovies>.toPresentationMovies() : List<Movies>{
    val list = mutableListOf<Movies>()
    this.forEach { list.add(it.toPresentationMovies()) }
    return list
}