package com.codeinglogs.data.store.trendingpersonweek

import com.codeinglogs.data.repository.trendingpersonweek.RemoteTrendingPersonWeekData
import javax.inject.Inject

class TrendingPersonWeekRemoteDataSore @Inject constructor (private val remoteTrendingPersonWeekData : RemoteTrendingPersonWeekData) :
    TrendingPersonWeekDataSore {
    override fun getRemoteDataSource(): RemoteTrendingPersonWeekData =  remoteTrendingPersonWeekData
}