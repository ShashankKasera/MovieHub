package com.codeinglogs.domain.model.movies.movieslist


data class MoviesListResponce(
    val page: Int?,
    val results: List<Movies>?,
    val total_pages: Int?,
    val total_results: Int?
){

}