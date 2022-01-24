package com.codeinglogs.data.repository.pagingtvshow

import androidx.paging.PagingData
import com.codeinglogs.data.model.tvshow.tvshowlist.TvShow
import kotlinx.coroutines.flow.Flow

interface RemoteTvShowPagingData {
    fun getPagingTrendingTvShow(): Flow<PagingData<TvShow>>
    fun getPagingPopularTvShow(): Flow<PagingData<TvShow>>
    fun getPagingTopRatedTvShow(): Flow<PagingData<TvShow>>
    fun getPagingSimilarTvShow(tvShowId : String): Flow<PagingData<TvShow>>
    fun getPagingSearchTvShow(tvShowSearch : String): Flow<PagingData<TvShow>>
}