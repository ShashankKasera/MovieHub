package com.codeinglogs.domain.usecase

import com.codeinglogs.domain.repository.TrendingTvShowRepositoryDomain
import javax.inject.Inject

class GetTrendingTvShow @Inject constructor(private val trendingTvShowRepositoryDomain: TrendingTvShowRepositoryDomain) {
    operator fun invoke() = trendingTvShowRepositoryDomain.getTrendingTvShow()
}