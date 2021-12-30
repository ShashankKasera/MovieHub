package com.codeinglogs.data.store.persondetails

import com.codeinglogs.data.repository.persondetails.RemotePersonDetailData
import javax.inject.Inject

class PersonDetailDataSoreImpl@Inject constructor(private val remotePersonDetailData : RemotePersonDetailData):
    PersonDetailsDataSore {
    override fun getRemoteDataSource()=remotePersonDetailData


}