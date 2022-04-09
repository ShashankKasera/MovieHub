package com.codeinglogs.data.store.tvshowdetails

import com.codeinglogs.data.repository.moviedetails.LocalMovieDetailData
import com.codeinglogs.data.repository.tvshowetails.LocalTvShowDetailData
import com.codeinglogs.data.repository.tvshowetails.RemoteTvShowDetailData
import javax.inject.Inject

class TvShowDetailDataSoreImpl @Inject constructor(
    private val remoteTvShowDetailData : RemoteTvShowDetailData,
    private val localTvShowDetailData: LocalTvShowDetailData
    ):
    TvShowDetailsDataSore {
    override fun getRemoteDataSource()=remoteTvShowDetailData
    override fun getLocalDataSource()=localTvShowDetailData


}