package com.codeinglogs.domain.usecase

import com.codeinglogs.domain.repository.MovieDetailRepositoryDomain
import javax.inject.Inject

class GetMovieDetails @Inject constructor(private val movieDetailRepositoryDomain: MovieDetailRepositoryDomain) {

    operator fun invoke(id:String) = movieDetailRepositoryDomain.getMovieDetail(id)
}