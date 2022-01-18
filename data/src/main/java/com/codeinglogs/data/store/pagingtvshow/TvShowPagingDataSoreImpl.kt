package com.codeinglogs.data.store.pagingtvshow


import com.codeinglogs.data.repository.pagingtvshow.RemoteTvShowPagingData
import javax.inject.Inject

class TvShowPagingDataSoreImpl @Inject constructor (
    private val remoteTvShowPagingData : RemoteTvShowPagingData
    ) : TvShowPagingDataSore {
    override fun getRemoteDataSource(): RemoteTvShowPagingData = remoteTvShowPagingData

}