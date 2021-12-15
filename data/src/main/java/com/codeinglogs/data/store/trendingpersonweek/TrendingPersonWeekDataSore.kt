package com.codeinglogs.data.store.trendingpersonweek

import com.codeinglogs.data.repository.trendingpersonweek.RemoteTrendingPersonWeekData

interface TrendingPersonWeekDataSore {

    fun getRemoteDataSource() : RemoteTrendingPersonWeekData
}