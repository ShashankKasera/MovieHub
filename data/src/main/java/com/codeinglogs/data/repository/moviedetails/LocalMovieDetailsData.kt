package com.codeinglogs.data.repository.moviedetails

import com.codeinglogs.data.model.movies.moviedetail.MovieDetailsDisplay

interface LocalMovieDetailData {

    fun getMovieDetail(): MovieDetailsDisplay

}