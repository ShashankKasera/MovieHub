package com.codeinglogs.domain.repository

import androidx.paging.PagingData
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.movies.movieslist.Movies
import com.codeinglogs.domain.model.tvshow.tvshowslist.TvShow
import com.codeinglogs.domain.model.tvshow.tvshowslist.TvShowsListResponse
import kotlinx.coroutines.flow.Flow

interface TrendingTvShowRepositoryDomain {

    fun getTrendingTvShow() : Flow<State<TvShowsListResponse>>

    fun getPagingTrendingTvShow() : Flow<PagingData<TvShow>>
}