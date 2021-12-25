package com.codeinglogs.data.store.home

import com.codeinglogs.data.repository.home.LocalHomeData
import com.codeinglogs.data.repository.home.RemoteHomeData
import javax.inject.Inject

class HomeRemoteDataSore @Inject constructor (private val remoteHomeData : RemoteHomeData,private val localHomeData: LocalHomeData) :
    HomeDataSore {
    override fun getRemoteDataSource(): RemoteHomeData =  remoteHomeData
    override fun getLocalDataSource(): LocalHomeData =localHomeData
}