package com.codeinglogs.domain.usecase.bookmark

import com.codeinglogs.domain.repository.MovieDetailRepositoryDomain
import javax.inject.Inject

data class UpdateBookmarkMovies @Inject constructor(private val movieDetailRepositoryDomain: MovieDetailRepositoryDomain) {
    operator fun invoke(id:Long) = movieDetailRepositoryDomain.updateBookmarkMovies(id)
}