package com.codeinglogs.remote.model.movies.movieslist


import com.codeinglogs.data.model.movies.movieslist.MoviesListResponse as DataMoviesListResponse
import com.codeinglogs.data.model.movies.movieslist.Movies as DataMovies

data class MoviesListResponse(
    val page: Int?,
    val results: List<Movies>?,
    val total_pages: Int?,
    val total_results: Int?
)

fun MoviesListResponse.toDataMoviesListResponse() = DataMoviesListResponse(
    page = page?:0,
    total_pages = total_pages?:0,
    total_results = total_results?:0,
    results = results?.toDataMovies()?: listOf()
)

fun List<Movies>.toDataMovies() : List<DataMovies>{
    val list = mutableListOf<DataMovies>()
    this.forEach { list.add(it.toDataMovies()) }
    return list
}


