package com.codeinglogs.domain.usecase

import com.codeinglogs.domain.repository.TrendingPersonWeekRepositoryDomain
import javax.inject.Inject

class GetTrendingPersonWeek @Inject constructor(private val trendingPersonWeekRepositoryDomain: TrendingPersonWeekRepositoryDomain) {
    operator fun invoke() = trendingPersonWeekRepositoryDomain.getTrendingPersonWeek()
}