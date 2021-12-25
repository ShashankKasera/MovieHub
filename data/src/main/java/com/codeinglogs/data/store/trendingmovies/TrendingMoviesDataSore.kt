package com.codeinglogs.data.store.trendingmovies

import com.codeinglogs.data.repository.trendingmovies.LocalTrendingMoviesData
import com.codeinglogs.data.repository.trendingmovies.RemoteTrendingMoviesData

interface TrendingMoviesDataSore {
    fun getRemoteDataSource() : RemoteTrendingMoviesData
    fun getLocalDataSource() : LocalTrendingMoviesData
}