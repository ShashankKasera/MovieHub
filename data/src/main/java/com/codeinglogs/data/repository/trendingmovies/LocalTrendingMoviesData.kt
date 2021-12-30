package com.codeinglogs.data.repository.trendingmovies


import com.codeinglogs.data.model.movies.movieslist.Movies
import com.codeinglogs.data.model.movies.movieslist.MoviesListResponse

interface LocalTrendingMoviesData {
    suspend fun getTrendingMovies() : List<Movies>
    suspend fun insertTrendingMovies(trendingMovies : MoviesListResponse)
}