package com.codeinglogs.data.repository.moviedetails

import com.codeinglogs.data.model.movies.moviedetail.MovieDetailsDisplay
import com.codeinglogs.data.model.movies.mylist.MyMovieList
import com.codeinglogs.data.model.movies.mylist.MyMovieListDetails

interface LocalMovieDetailData {

    suspend fun getMovieDetail(movieId: String): MovieDetailsDisplay
    suspend fun getMyMoviesList(): List<MyMovieList>
    suspend fun getMyMoviesListDetails(myMovieListId: Long,movieId: String): List<MyMovieListDetails>
    suspend fun getAllMyMoviesListDetails(): List<MyMovieListDetails>
    suspend fun isMovieDetailExist(movieId: String): Boolean
    suspend fun insertMovieDetail(MovieDetailsDisplay : MovieDetailsDisplay)

    suspend fun isBookmarkMoviesIsExist(movieId : Long): Boolean
    suspend fun updateBookmarkMovies(Bookmark: Long)

    suspend fun insertMyMoviesList(name: String,movieId:String) :Boolean
    suspend fun insertMyMoviesListDetails(myMoviesListId: Long, movieId: Long):Long
    suspend fun getAllMyMoviesList():List<MyMovieList>

}