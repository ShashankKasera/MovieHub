package com.codeinglogs.data.domainrepositoryimp

import android.util.Log
import androidx.paging.PagingData
import androidx.paging.map
import com.codeinglogs.data.model.movies.movieslist.toDomainMovies
import com.codeinglogs.data.store.pagingmovies.MoviesPagingDataSore
import com.codeinglogs.domain.model.movies.movieenum.MovieType
import com.codeinglogs.domain.model.movies.movieslist.Movies
import com.codeinglogs.domain.repository.MoviesPagingRepositoryDomain
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MoviesPagingRepositoryDomainImp @Inject constructor (
    private val moviesPagingDataSore : MoviesPagingDataSore
    ) : MoviesPagingRepositoryDomain {
    override fun getPagingMovies(
        movieType: MovieType,
        id: String,
        movieSearch: String

    )= when (movieType) {
        MovieType.TRENDING -> {
            Log.i("jkwn", "getPagingMovies: TRENDING $movieType")
            moviesPagingDataSore.getRemoteDataSource()
                .getPagingTrendingMovies().map { it -> it.map { it.toDomainMovies() } }
        }
        MovieType.POPULAR -> {
            Log.i("jkwn", "getPagingMovies: POPULAR $movieType")
            moviesPagingDataSore.getRemoteDataSource()
                .getPagingPopularMovies().map { it -> it.map { it.toDomainMovies() } }

        }
        MovieType.TOP_RATED -> {
            Log.i("jkwn", "getPagingMovies: TOP_RATED $movieType")
            moviesPagingDataSore.getRemoteDataSource()
                .getPagingTopRatedMovies().map { it -> it.map { it.toDomainMovies() } }
        }
        MovieType.SIMILAR -> {
            moviesPagingDataSore.getRemoteDataSource()
                .getPagingSimilarMovies(id).map { it -> it.map { it.toDomainMovies() } }
        }
        MovieType.SEARCH -> {
            moviesPagingDataSore.getRemoteDataSource()
                .getPagingSearchMovies(movieSearch).map { it -> it.map { it.toDomainMovies() } }
        }
    }
}