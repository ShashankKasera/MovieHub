package com.codeinglogs.data.repository.maylist

import com.codeinglogs.data.model.movies.mylist.MyMovieListDetails

interface LocalMyMovieListDetailsData {

    suspend fun insertMyMoviesListDetails(myMovieListId:Long,movieId: Long)
    suspend fun getMyMoviesListDetails(myMovieListId:Long,movieId: Long) : List<MyMovieListDetails>
}