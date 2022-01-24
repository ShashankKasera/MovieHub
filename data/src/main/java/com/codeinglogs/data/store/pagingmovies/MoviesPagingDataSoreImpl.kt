package com.codeinglogs.data.store.pagingmovies


import com.codeinglogs.data.repository.pagingmovies.RemoteMoviesPagingData
import javax.inject.Inject

class MoviesPagingDataSoreImpl @Inject constructor (
    private val remoteMoviesPagingData : RemoteMoviesPagingData
) : MoviesPagingDataSore {
    override fun getRemoteDataSource(): RemoteMoviesPagingData =  remoteMoviesPagingData
}