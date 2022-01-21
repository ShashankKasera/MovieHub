package com.codeinglogs.data.domainrepositoryimp

import android.util.Log
import androidx.paging.map
import com.codeinglogs.data.model.tvshow.tvshowlist.toDomainTrendingTvShowResult
import com.codeinglogs.data.store.pagingtvshow.TvShowPagingDataSore
import com.codeinglogs.domain.model.tvshow.tvshowenum.TvShowType
import com.codeinglogs.domain.repository.TvShowPagingRepositoryDomain
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TvShowPagingRepositoryDomainImp @Inject constructor (
    private val tvShowPagingDataSore : TvShowPagingDataSore) :
    TvShowPagingRepositoryDomain {

    override fun getPagingTvShow(tvShowType: TvShowType)=
        when(tvShowType) {
            TvShowType.TRENDING -> {
                Log.i("jkwn", "getPagingMovies: TRENDING $tvShowType")
                tvShowPagingDataSore.getRemoteDataSource()
                    .getPagingTrendingTvShow().map { it -> it.map { it.toDomainTrendingTvShowResult() } }
            }
            TvShowType.POPULAR -> {
                Log.i("jkwn", "getPagingTvShow: POPULAR $tvShowType")
                tvShowPagingDataSore.getRemoteDataSource()
                    .getPagingPopularTvShow().map { it -> it.map { it.toDomainTrendingTvShowResult() } }

            }
            TvShowType.TOP_RATED -> {
                Log.i("jkwn", "getPagingTvShow: TOP_RATED $tvShowType")
                tvShowPagingDataSore.getRemoteDataSource()
                    .getPagingTopRatedTvShow().map { it -> it.map { it.toDomainTrendingTvShowResult() } }
            }
            TvShowType.SIMILAR -> {
                Log.i("jkwn", "getPagingTvShow: TOP_RATED $tvShowType")
                tvShowPagingDataSore.getRemoteDataSource()
                    .getPagingSimilarTvShow().map { it -> it.map { it.toDomainTrendingTvShowResult() } }
            }

        }
}