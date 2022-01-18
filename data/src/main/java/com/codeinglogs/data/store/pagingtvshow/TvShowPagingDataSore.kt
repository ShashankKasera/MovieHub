package com.codeinglogs.data.store.pagingtvshow

import com.codeinglogs.data.repository.pagingtvshow.RemoteTvShowPagingData

interface TvShowPagingDataSore {
    fun getRemoteDataSource() : RemoteTvShowPagingData
}