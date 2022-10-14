package com.codeinglogs.domain.repository.maylist

import com.codeinglogs.domain.model.State
import kotlinx.coroutines.flow.Flow

interface MyMoviesListDetailsRepositoryDomain {
    fun getMyMoviesListDetails(myMovieListId:Long,movieId: Long): Flow<State<Boolean>>
}