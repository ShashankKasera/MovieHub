package com.codeinglogs.domain.usecase

import com.codeinglogs.domain.repository.TrendingMoviesRepositoryDomain
import javax.inject.Inject

class GetTrendingMovies @Inject constructor(private val trendingMoviesRepositoryDomain: TrendingMoviesRepositoryDomain) {
     operator fun invoke() = trendingMoviesRepositoryDomain.getTrendingMovies()
}