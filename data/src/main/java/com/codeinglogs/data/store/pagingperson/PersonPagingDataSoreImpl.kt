package com.codeinglogs.data.store.pagingperson

import com.codeinglogs.data.repository.pagingPerson.RemotePersonPagingData
import javax.inject.Inject

class PersonPagingDataSoreImpl @Inject constructor (
    private val remotePersonPagingData : RemotePersonPagingData
) : PersonPagingDataSore {
    override fun getRemoteDataSource(): RemotePersonPagingData = remotePersonPagingData

}