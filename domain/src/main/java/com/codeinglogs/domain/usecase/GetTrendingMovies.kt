package com.codeinglogs.domain.usecase

import com.codeinglogs.domain.repository.TrendingMoviesRepository
import javax.inject.Inject

class GetTrendingMovies @Inject constructor(private val trendingMoviesRepository: TrendingMoviesRepository) {
     operator fun invoke() = trendingMoviesRepository.getTrendingMovies()
}