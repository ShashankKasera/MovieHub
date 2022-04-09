package com.codeinglogs.data.store.tvshowdetails

import com.codeinglogs.data.repository.tvshowetails.LocalTvShowDetailData
import com.codeinglogs.data.repository.tvshowetails.RemoteTvShowDetailData

interface TvShowDetailsDataSore {

    fun getRemoteDataSource() : RemoteTvShowDetailData
    fun getLocalDataSource() : LocalTvShowDetailData
}