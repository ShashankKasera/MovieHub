package com.codeinglogs.data.model.movies.movieslist

import com.codeinglogs.domain.model.movies.movieslist.MoviesListResponse as DomainMoviesListResponse
import com.codeinglogs.domain.model.movies.movieslist.Movies as DomainMovies

data class MoviesListResponse(
    val page: Int? = null,
    val results: List<Movies>?,
    val total_pages: Int? = null,
    val total_results: Int? = null
)

fun MoviesListResponse.toDomainMoviesListResponse() = DomainMoviesListResponse(
    page = page,
    total_pages = total_pages,
    total_results = total_results,
    results = results?.toDomainMovies()
)

fun List<Movies>.toDomainMovies() : List<DomainMovies>{
    val list = mutableListOf<DomainMovies>()
    this.forEach { list.add(it.toDomainMovies()) }
    return list
}


