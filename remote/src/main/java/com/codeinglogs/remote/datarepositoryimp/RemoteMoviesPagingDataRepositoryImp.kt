package com.codeinglogs.remote.datarepositoryimp

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.codeinglogs.data.model.movies.movieslist.Movies
import com.codeinglogs.data.repository.pagingmovies.RemoteMoviesPagingData
import com.codeinglogs.remote.pagingsource.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteMoviesPagingDataRepositoryImp @Inject constructor (
    private val trendingMoviePagingSource: TrendingMoviePagingSource,
    private val topRatedMoviePagingSource: TopRatedMoviePagingSource,
    private val popularMoviePagingSource: PopularMoviePagingSource,
    private val similarMoviePagingSourceFactory: SimilarMoviePagingSource.SimilarMoviePagingSourceFactory,
    private val searchMoviePagingSourceFactory: SearchMoviePagingSource.SearchMoviePagingSourceFactory
) : RemoteMoviesPagingData {

    override fun getPagingTrendingMovies(): Flow<PagingData<Movies>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                trendingMoviePagingSource }
        ).flow
    }

    override fun getPagingPopularMovies(): Flow<PagingData<Movies>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                popularMoviePagingSource }
        ).flow
    }

    override fun getPagingTopRatedMovies(): Flow<PagingData<Movies>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                topRatedMoviePagingSource }
        ).flow
    }

    override fun getPagingSimilarMovies(movieId : String): Flow<PagingData<Movies>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                similarMoviePagingSourceFactory.create(movieId) }
        ).flow
    }

    override fun getPagingSearchMovies(movieSearch : String): Flow<PagingData<Movies>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                searchMoviePagingSourceFactory.create(movieSearch) }
        ).flow
    }

}