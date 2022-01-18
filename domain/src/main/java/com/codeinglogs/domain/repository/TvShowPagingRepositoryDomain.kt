package com.codeinglogs.domain.repository

import androidx.paging.PagingData
import com.codeinglogs.domain.model.tvshow.tvshowenum.TvShowType
import com.codeinglogs.domain.model.tvshow.tvshowslist.TvShow
import kotlinx.coroutines.flow.Flow

interface TvShowPagingRepositoryDomain {
    fun getPagingTvShow(tvShowType: TvShowType): Flow<PagingData<TvShow>>
}