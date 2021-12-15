package com.codeinglogs.remote.model.trendingmovies


import com.codeinglogs.data.model.trendingmovies.TrendingMoviesList as DataTrendingMoviesList
import com.codeinglogs.data.model.trendingmovies.Result as DataResult

data class TrendingMoviesList(
    val page: Int?,
    val results: List<Result>,
    val total_pages: Int?,
    val total_results: Int?
)

fun TrendingMoviesList.toDataTrendingMoviesList() = DataTrendingMoviesList(
    page = page,
    total_pages = total_pages,
    total_results = total_results,
    results = results.toDataTrendingMoviesResultList()
)

fun List<Result>.toDataTrendingMoviesResultList() : List<DataResult>{
    val list = mutableListOf<DataResult>()
    this.forEach { list.add(it.toDataTrendingMoviesResult()) }
    return list
}


