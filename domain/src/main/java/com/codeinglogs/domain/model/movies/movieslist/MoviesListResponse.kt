package com.codeinglogs.domain.model.movies.movieslist


data class MoviesListResponse(
    val page: Int? = null,
    val results: List<Movies>?,
    val total_pages: Int?= null,
    val total_results: Int?= null
){

}