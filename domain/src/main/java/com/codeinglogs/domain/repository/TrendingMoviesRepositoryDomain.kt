package com.codeinglogs.domain.repository

import androidx.paging.PagingData
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.movies.movieslist.Movies
import com.codeinglogs.domain.model.movies.movieslist.MoviesListResponse
import kotlinx.coroutines.flow.Flow

interface TrendingMoviesRepositoryDomain {
    fun getTrendingMovies() : Flow<State<MoviesListResponse>>
    fun getPagingTrendingMovies() : Flow<PagingData<Movies>>
}