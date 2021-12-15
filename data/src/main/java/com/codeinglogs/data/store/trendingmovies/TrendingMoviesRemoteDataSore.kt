package com.codeinglogs.data.store.trendingmovies


import com.codeinglogs.data.repository.trendingmovies.RemoteTrendingMoviesData
import javax.inject.Inject

class TrendingMoviesRemoteDataSore @Inject constructor (private val remoteTrendingMoviesData : RemoteTrendingMoviesData) : TrendingMoviesDataSore {
    override fun getRemoteDataSource(): RemoteTrendingMoviesData =  remoteTrendingMoviesData
}