package com.codeinglogs.data.model.trendingmovies

import com.codeinglogs.domain.model.trendingmovies.TrendingMoviesList as DomainTrendingMoviesList
import com.codeinglogs.domain.model.trendingmovies.Result as DomainResult

data class TrendingMoviesList(
    val page: Int?,
    val results: List<Result>?,
    val total_pages: Int?,
    val total_results: Int?
)

fun TrendingMoviesList.toDomainTrendingMoviesList() = DomainTrendingMoviesList(
    page = page,
    total_pages = total_pages,
    total_results = total_results,
    results = results?.toDomainTrendingMoviesResultList()
)

fun List<Result>.toDomainTrendingMoviesResultList() : List<DomainResult>{
    val list = mutableListOf<DomainResult>()
    this.forEach { list.add(it.toDomainTrendingMoviesResult()) }
    return list
}


