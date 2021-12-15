package com.codeinglogs.data.store.trendingtvshow


import com.codeinglogs.data.repository.trendingmovies.RemoteTrendingMoviesData
import com.codeinglogs.data.repository.trendingtvshow.RemoteTrendingTvShowData
import javax.inject.Inject

class TrendingTvShowRemoteDataSore @Inject constructor (private val remoteTrendingTvShowData : RemoteTrendingTvShowData) : TrendingTvShowDataSore {
    override fun getRemoteDataSource(): RemoteTrendingTvShowData =  remoteTrendingTvShowData
}