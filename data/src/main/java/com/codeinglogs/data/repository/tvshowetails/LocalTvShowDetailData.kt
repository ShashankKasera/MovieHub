package com.codeinglogs.data.repository.tvshowetails

import com.codeinglogs.data.model.tvshow.tvshowdetails.TvShowDetailsDisplay

interface LocalTvShowDetailData {

    suspend fun getTvShowDetail(tvShowId: String): TvShowDetailsDisplay
    suspend fun isTvShowDetailExist(tvShowId: String): Boolean
    suspend fun insertTvShowDetail(TvShowDetailsDisplay : TvShowDetailsDisplay)

}