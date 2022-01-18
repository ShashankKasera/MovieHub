package com.codeinglogs.data.store.pagingperson

import com.codeinglogs.data.repository.pagingPerson.RemotePersonPagingData

interface PersonPagingDataSore {

    fun getRemoteDataSource() : RemotePersonPagingData
}