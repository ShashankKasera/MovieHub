package com.codeinglogs.data.store.person

import com.codeinglogs.data.repository.person.LocalPersonData
import com.codeinglogs.data.repository.person.RemotePersonData

interface PersonDataSore {
    fun getRemoteDataSource() : RemotePersonData
    fun getLocalDataSource() : LocalPersonData
}