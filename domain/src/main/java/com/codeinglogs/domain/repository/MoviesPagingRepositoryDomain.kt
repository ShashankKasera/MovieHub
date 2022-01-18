package com.codeinglogs.domain.repository

import androidx.paging.PagingData
import com.codeinglogs.domain.model.movies.movieenum.MovieType
import com.codeinglogs.domain.model.movies.movieslist.Movies
import kotlinx.coroutines.flow.Flow

interface MoviesPagingRepositoryDomain {
    fun getPagingMovies(movieType: MovieType): Flow<PagingData<Movies>>
}