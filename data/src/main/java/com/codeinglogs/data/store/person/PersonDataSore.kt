package com.codeinglogs.data.store.person

import com.codeinglogs.data.repository.person.RemotePersonData
import com.codeinglogs.data.repository.trendingmovies.RemoteTrendingMoviesData

interface PersonDataSore {
    fun getRemoteDataSource() : RemotePersonData
}