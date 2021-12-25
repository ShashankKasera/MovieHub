package com.codeinglogs.data.store.home

import com.codeinglogs.data.repository.home.LocalHomeData
import com.codeinglogs.data.repository.home.RemoteHomeData

interface HomeDataSore {
    fun getRemoteDataSource() : RemoteHomeData
    fun getLocalDataSource() : LocalHomeData
}