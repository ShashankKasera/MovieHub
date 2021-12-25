package com.codeinglogs.data.repository.moviedetails

import com.codeinglogs.data.model.moviedetail.MovieDetailsDisplay

interface LocalMovieDetailData {

    fun getMovieDetail(): MovieDetailsDisplay

}