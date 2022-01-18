package com.codeinglogs.data.repository.pagingmovies

import androidx.paging.PagingData
import com.codeinglogs.data.model.movies.movieslist.Movies
import kotlinx.coroutines.flow.Flow

interface RemoteMoviesPagingData {
    fun getPagingTrendingMovies(): Flow<PagingData<Movies>>
    fun getPagingPopularMovies(): Flow<PagingData<Movies>>
    fun getPagingTopRatedMovies(): Flow<PagingData<Movies>>
}