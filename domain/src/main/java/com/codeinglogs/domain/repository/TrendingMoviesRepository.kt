package com.codeinglogs.domain.repository

import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.trendingmovies.TrendingMoviesList
import kotlinx.coroutines.flow.Flow

interface TrendingMoviesRepository {
    fun getTrendingMovies() : Flow<State<TrendingMoviesList>>
}