package com.codeinglogs.domain.usecase

import com.codeinglogs.domain.repository.TrendingPersonWeekRepositoryDomain
import javax.inject.Inject

class GetPagingTrendingPersonWeek @Inject constructor(private val trendingPersonWeekRepositoryDomain: TrendingPersonWeekRepositoryDomain) {
    operator fun invoke() = trendingPersonWeekRepositoryDomain.getPagingTrendingPersonWeek()
}