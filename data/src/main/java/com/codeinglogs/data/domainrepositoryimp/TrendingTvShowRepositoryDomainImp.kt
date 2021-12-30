package com.codeinglogs.data.domainrepositoryimp

import com.codeinglogs.data.maper.toDomainState
import com.codeinglogs.data.store.trendingtvshow.TrendingTvShowDataSore
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.tvshow.tvshowslist.TvShowsListResponse
import com.codeinglogs.domain.repository.TrendingTvShowRepositoryDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TrendingTvShowRepositoryDomainImp @Inject constructor (private val trendingTvShowDataSore : TrendingTvShowDataSore) :
    TrendingTvShowRepositoryDomain {



    override fun getTrendingTvShow(): Flow<State<TvShowsListResponse>> {
        return flow {
            trendingTvShowDataSore.getRemoteDataSource().getTrendingTvShow().collect {
                emit(it.toDomainState())
            }
        }
    }

}