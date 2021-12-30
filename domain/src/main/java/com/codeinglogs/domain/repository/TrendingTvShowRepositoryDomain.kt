package com.codeinglogs.domain.repository

import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.tvshow.tvshowslist.TvShowsListResponse
import kotlinx.coroutines.flow.Flow

interface TrendingTvShowRepositoryDomain {

    fun getTrendingTvShow() : Flow<State<TvShowsListResponse>>
}