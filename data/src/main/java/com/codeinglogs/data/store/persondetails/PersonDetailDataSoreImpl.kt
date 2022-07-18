package com.codeinglogs.data.store.persondetails

import com.codeinglogs.data.repository.persondetails.LocalPersonDetailData
import com.codeinglogs.data.repository.persondetails.RemotePersonDetailData
import javax.inject.Inject

class PersonDetailDataSoreImpl@Inject constructor(
    private val remotePersonDetailData : RemotePersonDetailData,
    private val localPersonDetailData: LocalPersonDetailData
):
    PersonDetailsDataSore {
    override fun getRemoteDataSource()=remotePersonDetailData
    override fun getLocalDataSource()=localPersonDetailData


}