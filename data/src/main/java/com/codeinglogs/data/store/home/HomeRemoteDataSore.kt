package com.codeinglogs.data.store.home

import com.codeinglogs.data.repository.home.RemoteHomeData
import javax.inject.Inject

class HomeRemoteDataSore @Inject constructor (private val remoteHomeData : RemoteHomeData) :
    HomeDataSore {
    override fun getRemoteDataSource(): RemoteHomeData =  remoteHomeData
}