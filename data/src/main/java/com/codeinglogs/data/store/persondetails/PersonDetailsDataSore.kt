package com.codeinglogs.data.store.persondetails

import com.codeinglogs.data.repository.persondetails.RemotePersonDetailData

interface PersonDetailsDataSore {

    fun getRemoteDataSource() : RemotePersonDetailData
}