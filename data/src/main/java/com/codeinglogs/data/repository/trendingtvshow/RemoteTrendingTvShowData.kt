package com.codeinglogs.data.repository.trendingtvshow

import androidx.paging.PagingData
import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.tvshow.tvshowlist.TvShow
import com.codeinglogs.data.model.tvshow.tvshowlist.TvShowsListResponse
import kotlinx.coroutines.flow.Flow

interface RemoteTrendingTvShowData {
    fun getTrendingTvShow() : Flow<State<TvShowsListResponse>>

    fun getPagingTrendingTvShow() : Flow<PagingData<TvShow>>
}