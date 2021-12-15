package com.codeinglogs.data.store.trendingtvshow

import com.codeinglogs.data.repository.trendingmovies.RemoteTrendingMoviesData
import com.codeinglogs.data.repository.trendingtvshow.RemoteTrendingTvShowData

interface TrendingTvShowDataSore {
    fun getRemoteDataSource() : RemoteTrendingTvShowData
}