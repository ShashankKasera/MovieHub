package com.codeinglogs.data.model.movies.movieslist

import com.codeinglogs.domain.model.movies.movieslist.MoviesListResponce as DomainMoviesListResponce
import com.codeinglogs.domain.model.movies.movieslist.Movies as DomainMovies

data class MoviesListResponce(
    val page: Int?,
    val results: List<Movies>?,
    val total_pages: Int?,
    val total_results: Int?
)

fun MoviesListResponce.toDomainMoviesListResponce() = DomainMoviesListResponce(
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


