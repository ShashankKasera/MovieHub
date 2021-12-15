package com.codeinglogs.data.store.person

import com.codeinglogs.data.repository.person.RemotePersonData
import javax.inject.Inject

class PersonRemoteDataSore @Inject constructor (private val remoteTrendingMoviesData : RemotePersonData) :
    PersonDataSore {
    override fun getRemoteDataSource(): RemotePersonData =  remoteTrendingMoviesData
}