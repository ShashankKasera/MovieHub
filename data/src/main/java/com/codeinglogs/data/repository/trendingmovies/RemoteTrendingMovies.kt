package com.codeinglogs.data.repository.trendingmovies

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.trendingmovies.TrendingMoviesList
import kotlinx.coroutines.flow.Flow

interface RemoteTrendingMovies {
    fun getTrendingMovies() : Flow<State<TrendingMoviesList>>
}