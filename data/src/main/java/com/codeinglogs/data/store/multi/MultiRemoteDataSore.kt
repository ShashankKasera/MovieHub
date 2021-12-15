package com.codeinglogs.data.store.multi

import com.codeinglogs.data.repository.multi.RemoteMultiData
import javax.inject.Inject

class MultiRemoteDataSore @Inject constructor (private val remoteMultiData : RemoteMultiData) :
    MultiDataSore {
    override fun getRemoteDataSource(): RemoteMultiData =  remoteMultiData
}