package com.codeinglogs.data.repository.trendingmovies

import androidx.paging.PagingData
import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.movies.movieslist.Movies
import com.codeinglogs.data.model.movies.movieslist.MoviesListResponse
import kotlinx.coroutines.flow.Flow

interface RemoteTrendingMoviesData {
    fun getTrendingMovies() : Flow<State<MoviesListResponse>>
    fun getPagingTrendingMovies() : Flow<PagingData<Movies>>
}