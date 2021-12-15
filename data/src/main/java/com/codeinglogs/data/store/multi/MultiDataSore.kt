package com.codeinglogs.data.store.multi

import com.codeinglogs.data.repository.multi.RemoteMultiData
import com.codeinglogs.data.repository.trendingmovies.RemoteTrendingMoviesData

interface MultiDataSore {
    fun getRemoteDataSource() : RemoteMultiData
}