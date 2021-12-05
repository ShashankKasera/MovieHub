package com.codeinglogs.data.store.trendingmovies

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.trendingmovies.TrendingMoviesList
import com.codeinglogs.data.repository.trendingmovies.RemoteTrendingMovies
import kotlinx.coroutines.flow.Flow

interface TrendingMoviesDataSore {
    fun getRemoteDataSource() : RemoteTrendingMovies
}