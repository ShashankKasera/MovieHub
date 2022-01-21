package com.codeinglogs.remote.datarepositoryimp

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.tvshow.tvshowlist.TvShow
import com.codeinglogs.data.model.tvshow.tvshowlist.TvShowsListResponse
import com.codeinglogs.data.repository.pagingtvshow.RemoteTvShowPagingData
import com.codeinglogs.remote.model.tvshows.tvshowslist.toDataTvShowsListResponse
import com.codeinglogs.remote.pagingsource.*
import com.codeinglogs.remote.request.TvShowRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

private const val TAG = "123MainActivity"
class RemoteTvShowPagingDataRepositoryImp @Inject constructor (
    private val trendingTvShowPagingSource: TrendingTvShowPagingSource,
    private val topRatedTvShowPagingSource: TopRatedTvShowPagingSource,
    private val popularTvShowPagingSource: PopularTvShowPagingSource,
    private val similarTvShowPagingSource: SimilarTvShowPagingSource,
    ) :
    RemoteTvShowPagingData {


    override fun getPagingTrendingTvShow(): Flow<PagingData<TvShow>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { trendingTvShowPagingSource }
        ).flow
    }

    override fun getPagingPopularTvShow(): Flow<PagingData<TvShow>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { popularTvShowPagingSource }
        ).flow
    }

    override fun getPagingTopRatedTvShow(): Flow<PagingData<TvShow>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { topRatedTvShowPagingSource }
        ).flow
    }

    override fun getPagingSimilarTvShow(): Flow<PagingData<TvShow>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { similarTvShowPagingSource }
        ).flow
    }


}