package com.codeinglogs.data.repository.tvshowetails

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.tvshow.tvshowdetails.TvShowDetailsDisplay
import kotlinx.coroutines.flow.Flow

interface RemoteTvShowDetailData {
    fun getTvShowDetail(id:String) : Flow<State<TvShowDetailsDisplay>>
}