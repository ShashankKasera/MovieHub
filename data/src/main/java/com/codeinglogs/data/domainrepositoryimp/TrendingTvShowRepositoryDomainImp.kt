package com.codeinglogs.data.domainrepositoryimp

import androidx.paging.PagingData
import androidx.paging.map
import com.codeinglogs.data.maper.toDomainState
import com.codeinglogs.data.model.movies.movieslist.toDomainMovies
import com.codeinglogs.data.model.tvshow.tvshowlist.toDomainTrendingTvShowResult
import com.codeinglogs.data.store.trendingtvshow.TrendingTvShowDataSore
import com.codeinglogs.domain.model.State
import com.codeinglogs.domain.model.tvshow.tvshowslist.TvShow
import com.codeinglogs.domain.model.tvshow.tvshowslist.TvShowsListResponse
import com.codeinglogs.domain.repository.TrendingTvShowRepositoryDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
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

    override fun getPagingTrendingTvShow()=
        trendingTvShowDataSore.getRemoteDataSource()
            .getPagingTrendingTvShow().map { it->it.map { it.toDomainTrendingTvShowResult() } }



}