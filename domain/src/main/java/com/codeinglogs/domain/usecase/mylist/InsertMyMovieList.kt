package com.codeinglogs.domain.usecase.mylist

import com.codeinglogs.domain.repository.MovieDetailRepositoryDomain
import javax.inject.Inject

data class InsertMyMovieList  @Inject constructor(private val movieDetailRepositoryDomain: MovieDetailRepositoryDomain) {
    operator fun invoke(name: String,movieId:String) = movieDetailRepositoryDomain.insertMyMoviesList(name,movieId)
}