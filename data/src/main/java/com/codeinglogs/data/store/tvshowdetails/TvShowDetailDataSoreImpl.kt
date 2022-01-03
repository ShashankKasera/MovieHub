package com.codeinglogs.data.store.tvshowdetails

import com.codeinglogs.data.repository.tvshowetails.RemoteTvShowDetailData
import javax.inject.Inject

class TvShowDetailDataSoreImpl @Inject constructor(private val remoteTvShowDetailData : RemoteTvShowDetailData):
    TvShowDetailsDataSore {
    override fun getRemoteDataSource()=remoteTvShowDetailData


}