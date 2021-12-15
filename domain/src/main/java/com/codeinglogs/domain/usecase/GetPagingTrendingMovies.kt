package com.codeinglogs.domain.usecase

import com.codeinglogs.domain.repository.TrendingMoviesRepositoryDomain
import com.codeinglogs.domain.repository.TrendingPersonWeekRepositoryDomain
import javax.inject.Inject

class GetPagingTrendingMovies @Inject constructor(private val trendingMoviesRepositoryDomain: TrendingMoviesRepositoryDomain) {
    operator fun invoke() = trendingMoviesRepositoryDomain.getPagingTrendingMovies()
}