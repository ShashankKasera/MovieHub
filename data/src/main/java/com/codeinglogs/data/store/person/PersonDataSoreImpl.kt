package com.codeinglogs.data.store.person

import com.codeinglogs.data.repository.person.LocalPersonData
import com.codeinglogs.data.repository.person.RemotePersonData
import javax.inject.Inject

class PersonDataSoreImpl @Inject constructor (private val remotePersonData : RemotePersonData, private val localPersonData : LocalPersonData) :
    PersonDataSore {
    override fun getRemoteDataSource(): RemotePersonData =  remotePersonData
    override fun getLocalDataSource(): LocalPersonData = localPersonData
}