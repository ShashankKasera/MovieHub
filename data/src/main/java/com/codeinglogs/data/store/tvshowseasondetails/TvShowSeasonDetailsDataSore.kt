package com.codeinglogs.data.store.tvshowseasondetails

import com.codeinglogs.data.repository.tvshowseasondetails.RemoteTvShowSeasonDetailsData

interface TvShowSeasonDetailsDataSore {

    fun getRemoteDataSource() : RemoteTvShowSeasonDetailsData
}