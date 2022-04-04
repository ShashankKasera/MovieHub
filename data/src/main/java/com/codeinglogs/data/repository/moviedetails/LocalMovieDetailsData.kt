package com.codeinglogs.data.repository.moviedetails

import com.codeinglogs.data.model.movies.moviedetail.MovieDetailsDisplay

interface LocalMovieDetailData {

    suspend fun getMovieDetail(movieId: String): MovieDetailsDisplay
    suspend fun isMovieDetailExist(movieId: String): Boolean
    suspend fun insertMovieDetail(MovieDetailsDisplay : MovieDetailsDisplay)

}