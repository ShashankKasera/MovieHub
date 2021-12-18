package com.codeinglogs.remote.model.movies.movieslist


import com.codeinglogs.data.model.movies.movieslist.MoviesListResponce as DataMoviesListResponce
import com.codeinglogs.data.model.movies.movieslist.Movies as DataMovies

data class MoviesListResponce(
    val page: Int?,
    val results: List<Movies>,
    val total_pages: Int?,
    val total_results: Int?
)

fun MoviesListResponce.toDataMoviesListResponce() = DataMoviesListResponce(
    page = page,
    total_pages = total_pages,
    total_results = total_results,
    results = results.toDataMovies()
)

fun List<Movies>.toDataMovies() : List<DataMovies>{
    val list = mutableListOf<DataMovies>()
    this.forEach { list.add(it.toDataMovies()) }
    return list
}


