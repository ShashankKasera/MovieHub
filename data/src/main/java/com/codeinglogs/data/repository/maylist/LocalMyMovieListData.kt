package com.codeinglogs.data.repository.maylist

import com.codeinglogs.data.model.movies.moviedetail.MovieDetailsDisplay
import com.codeinglogs.data.model.movies.mylist.MyMovieList

interface LocalMyMovieListData {
    suspend fun insertMyMoviesList(list: String) :Long
    suspend fun insertMyMoviesListDetails(myMoviesListId: Long, movieId: Long):Long
    suspend fun getAllMyMoviesList():List<MyMovieList>
}