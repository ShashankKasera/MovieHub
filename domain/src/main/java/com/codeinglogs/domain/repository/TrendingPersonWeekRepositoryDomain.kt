package com.codeinglogs.domain.repository

import androidx.paging.PagingData
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.trendingpersonweek.ResultTrendingPersonWeekList
import com.codeinglogs.domain.model.trendingpersonweek.TrendingPersonWeekList
import kotlinx.coroutines.flow.Flow

interface TrendingPersonWeekRepositoryDomain {
    fun getTrendingPersonWeek() : Flow<State<TrendingPersonWeekList>>
    fun getPagingTrendingPersonWeek() : Flow<PagingData<ResultTrendingPersonWeekList>>
}