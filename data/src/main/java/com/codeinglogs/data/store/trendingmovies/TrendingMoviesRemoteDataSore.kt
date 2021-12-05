package com.codeinglogs.data.store.trendingmovies


import com.codeinglogs.data.repository.trendingmovies.RemoteTrendingMovies
import javax.inject.Inject

class TrendingMoviesRemoteDataSore @Inject constructor (private val remoteTrendingMovies : RemoteTrendingMovies) : TrendingMoviesDataSore {
    override fun getRemoteDataSource(): RemoteTrendingMovies =  remoteTrendingMovies
}