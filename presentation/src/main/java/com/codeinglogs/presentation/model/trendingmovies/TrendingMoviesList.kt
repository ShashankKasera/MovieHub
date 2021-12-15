package com.codeinglogs.presentation.model.trendingmovies

import com.codeinglogs.domain.model.trendingmovies.TrendingMoviesList as DomainTrendingMoviesList
import com.codeinglogs.domain.model.trendingmovies.Result as DomainResult

data class TrendingMoviesList(
    val page: Int?,
    val results: List<Result>?,
    val total_pages: Int?,
    val total_results: Int?
)

fun DomainTrendingMoviesList.toPresentationTrendingMoviesList() =
    TrendingMoviesList(
        page = page,
        total_pages = total_pages,
        total_results = total_results,
        results = results?.toPresentationTrendingMoviesResultList()
    )

fun List<DomainResult>.toPresentationTrendingMoviesResultList() : List<Result>{
    val list = mutableListOf<Result>()
    this.forEach { list.add(it.toPresentationTrendingMoviesResult()) }
    return list
}