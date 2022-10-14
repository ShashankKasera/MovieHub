package com.codeinglogs.domain.usecase.mylist

import com.codeinglogs.domain.repository.maylist.MyMoviesListDetailsRepositoryDomain
import javax.inject.Inject

data class GetMyMovieListDetails @Inject constructor(private val myMoviesListDetailsRepositoryDomain: MyMoviesListDetailsRepositoryDomain) {
    operator fun invoke(myMovieListId:Long,movieId: Long) = myMoviesListDetailsRepositoryDomain.getMyMoviesListDetails(myMovieListId,movieId)
}
