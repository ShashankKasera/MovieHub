package com.codeinglogs.data.store.trendingmovies


import com.codeinglogs.data.repository.trendingmovies.LocalTrendingMoviesData
import com.codeinglogs.data.repository.trendingmovies.RemoteTrendingMoviesData
import javax.inject.Inject

class TrendingMoviesDataSoreImpl @Inject constructor (private val remoteTrendingMoviesData : RemoteTrendingMoviesData, private val localTrendingMoviesData : LocalTrendingMoviesData) : TrendingMoviesDataSore {
    override fun getRemoteDataSource(): RemoteTrendingMoviesData =  remoteTrendingMoviesData
    override fun getLocalDataSource(): LocalTrendingMoviesData =localTrendingMoviesData
}