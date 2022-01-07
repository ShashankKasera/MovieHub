package com.codeinglogs.data.store.tvshowseasondetails

import com.codeinglogs.data.repository.tvshowseasondetails.RemoteTvShowSeasonDetailsData
import javax.inject.Inject

class TvShowSeasonDetailsDataSoreImpl@Inject constructor(private val remoteTvShowSeasonDetailsData : RemoteTvShowSeasonDetailsData):
    TvShowSeasonDetailsDataSore {
    override fun getRemoteDataSource()=remoteTvShowSeasonDetailsData
}