package com.codeinglogs.domain.usecase

import com.codeinglogs.domain.model.tvshow.tvshowenum.TvShowType
import com.codeinglogs.domain.repository.TvShowPagingRepositoryDomain
import javax.inject.Inject

class GetTvShowPaging @Inject constructor(private val tvShowPagingRepositoryDomain: TvShowPagingRepositoryDomain) {
    operator fun invoke(tvShowType: TvShowType) = tvShowPagingRepositoryDomain.getPagingTvShow(tvShowType)
}