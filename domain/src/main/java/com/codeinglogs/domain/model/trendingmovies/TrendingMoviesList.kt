package com.codeinglogs.domain.model.trendingmovies


data class TrendingMoviesList(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
){

}