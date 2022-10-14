package com.codeinglogs.domain.repository.maylist

import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.movies.mylist.MyMovieList
import com.codeinglogs.domain.model.movies.mylist.MyMovieListDisplay
import kotlinx.coroutines.flow.Flow

interface MyMoviesListRepositoryDomain {
    fun getMyMoviesList(name: String,movieId:String): Flow<State<MyMovieListDisplay>>
}