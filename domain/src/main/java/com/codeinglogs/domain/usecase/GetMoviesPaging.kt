package com.codeinglogs.domain.usecase

import com.codeinglogs.domain.model.movies.movieenum.MovieType
import com.codeinglogs.domain.repository.MoviesPagingRepositoryDomain
import javax.inject.Inject

class GetMoviesPaging @Inject constructor(private val moviesPagingRepositoryDomain: MoviesPagingRepositoryDomain) {
    operator fun invoke(movieType: MovieType) = moviesPagingRepositoryDomain.getPagingMovies(movieType)
}