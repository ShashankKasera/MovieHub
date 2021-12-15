package com.codeinglogs.remote.request

import com.codeinglogs.remote.model.trendingpersonweek.TrendingPersonWeekList
import retrofit2.http.GET
import retrofit2.http.Query

interface TrendingPersonWeekRequest {
    @GET("trending/person/week")
    suspend fun getTrendingPersonWeek(@Query("page") page : Int): TrendingPersonWeekList

    @GET("trending/person/week")
    suspend fun getTrendingPersonWeek(): TrendingPersonWeekList


}