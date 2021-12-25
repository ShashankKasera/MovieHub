package com.codeinglogs.data.store.moviedetails

import com.codeinglogs.data.repository.moviedetails.RemoteMovieDetailData
import javax.inject.Inject

class MovieDetailDataSoreImpl @Inject constructor(private val remoteMovieDetailData : RemoteMovieDetailData):
MovieDetailsDataSore{
    override fun getRemoteDataSource()=remoteMovieDetailData


}