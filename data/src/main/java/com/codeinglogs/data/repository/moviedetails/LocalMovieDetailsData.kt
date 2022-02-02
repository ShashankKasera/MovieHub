package com.codeinglogs.data.repository.moviedetails

import com.codeinglogs.data.model.movies.moviedetail.MovieDetailsDisplay

interface LocalMovieDetailData {

    suspend fun getMovieDetail(id: String): MovieDetailsDisplay
    suspend fun insertMovieDetail(MovieDetailsDisplay : MovieDetailsDisplay)

}