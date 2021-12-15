package com.codeinglogs.data.repository.trendingpersonweek

import androidx.paging.PagingData
import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.trendingpersonweek.ResultTrendingPersonWeekList
import com.codeinglogs.data.model.trendingpersonweek.TrendingPersonWeekList
import kotlinx.coroutines.flow.Flow

interface RemoteTrendingPersonWeekData {
    fun getTrendingPersonWeek() : Flow<State<TrendingPersonWeekList>>
    fun getPagingTrendingPersonWeek() : Flow<PagingData<ResultTrendingPersonWeekList>>
}