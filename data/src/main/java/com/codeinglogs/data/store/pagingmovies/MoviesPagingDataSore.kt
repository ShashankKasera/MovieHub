package com.codeinglogs.data.store.pagingmovies

import com.codeinglogs.data.repository.pagingmovies.RemoteMoviesPagingData

interface MoviesPagingDataSore {
    fun getRemoteDataSource() : RemoteMoviesPagingData
}