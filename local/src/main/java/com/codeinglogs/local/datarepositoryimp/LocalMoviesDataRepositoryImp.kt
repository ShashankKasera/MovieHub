package com.codeinglogs.local.datarepositoryimp

import com.codeinglogs.data.model.movies.movieslist.Movies
import com.codeinglogs.data.model.movies.movieslist.MoviesListResponse
import com.codeinglogs.data.repository.trendingmovies.LocalTrendingMoviesData
import com.codeinglogs.local.dao.MoviesDao
import com.codeinglogs.local.dao.TrendingMoviesDao
import com.codeinglogs.local.entity.toDataMovies
import com.codeinglogs.local.entity.toLocalMovies
import com.codeinglogs.local.entity.toLocalTrendingMoviesList
import javax.inject.Inject

class LocalMoviesDataRepositoryImp @Inject constructor (private val trendingMoviesDao: TrendingMoviesDao,private val moviesDao: MoviesDao) :
    LocalTrendingMoviesData {

    override suspend fun getTrendingMovies(): List<Movies> {
        return trendingMoviesDao.getAllTrendingMovie().toDataMovies()
    }

    override suspend fun insertTrendingMovies(trendingMovies: MoviesListResponse) {
        moviesDao.insertAllMovies(*trendingMovies.results?.toLocalMovies()?.toTypedArray()?: arrayOf())
        trendingMoviesDao.insertAllTrendingMovies(*trendingMovies.results?.toLocalTrendingMoviesList()?.toTypedArray()?: arrayOf())
    }
}