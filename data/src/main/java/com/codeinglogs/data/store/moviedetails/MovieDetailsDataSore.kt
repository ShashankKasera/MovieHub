package com.codeinglogs.data.store.moviedetails

import com.codeinglogs.data.repository.moviedetails.LocalMovieDetailData
import com.codeinglogs.data.repository.moviedetails.RemoteMovieDetailData

interface MovieDetailsDataSore {

    fun getRemoteDataSource() : RemoteMovieDetailData
    //fun getLocalDataSource() : LocalMovieDetailData
}