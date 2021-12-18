package com.codeinglogs.data.repository.trendingtvshow

import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.tvshow.tvshowlist.TvShowsListResponce
import kotlinx.coroutines.flow.Flow

interface RemoteTrendingTvShowData {
    fun getTrendingTvShow() : Flow<State<TvShowsListResponce>>
}