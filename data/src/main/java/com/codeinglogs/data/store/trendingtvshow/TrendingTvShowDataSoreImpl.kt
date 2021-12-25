package com.codeinglogs.data.store.trendingtvshow


import com.codeinglogs.data.repository.trendingmovies.RemoteTrendingMoviesData
import com.codeinglogs.data.repository.trendingtvshow.LocalTrendingTvShowData
import com.codeinglogs.data.repository.trendingtvshow.RemoteTrendingTvShowData
import javax.inject.Inject

class TrendingTvShowDataSoreImpl @Inject constructor (private val remoteTrendingTvShowData : RemoteTrendingTvShowData, private val localTrendingTvShowData : LocalTrendingTvShowData) : TrendingTvShowDataSore {
    override fun getRemoteDataSource(): RemoteTrendingTvShowData = remoteTrendingTvShowData
    override fun getLocalDataSource(): LocalTrendingTvShowData = localTrendingTvShowData

}