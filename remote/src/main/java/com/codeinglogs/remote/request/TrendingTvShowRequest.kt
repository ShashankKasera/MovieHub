package com.codeinglogs.remote.request

import com.codeinglogs.remote.model.trendingtvshow.TrendingTvShowList
import retrofit2.http.GET

interface TrendingTvShowRequest {

    @GET("trending/tv/day")
    suspend fun getTrendingTvShow(): TrendingTvShowList
}