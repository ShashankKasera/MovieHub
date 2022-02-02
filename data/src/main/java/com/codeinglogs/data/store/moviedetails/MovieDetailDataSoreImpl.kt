package com.codeinglogs.data.store.moviedetails

import com.codeinglogs.data.repository.moviedetails.LocalMovieDetailData
import com.codeinglogs.data.repository.moviedetails.RemoteMovieDetailData
import javax.inject.Inject

class MovieDetailDataSoreImpl @Inject constructor(
    private val remoteMovieDetailData : RemoteMovieDetailData,
    private val localMovieDetailData: LocalMovieDetailData
 ): MovieDetailsDataSore{
    override fun getRemoteDataSource()=remoteMovieDetailData
    override fun getLocalDataSource()=localMovieDetailData

}