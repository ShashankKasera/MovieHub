package com.codeinglogs.remote.datarepositoryimp

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.codeinglogs.data.model.tvshow.tvshowlist.TvShow
import com.codeinglogs.data.repository.pagingtvshow.RemoteTvShowPagingData
import com.codeinglogs.remote.pagingsource.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

private const val TAG = "123MainActivity"
class RemoteTvShowPagingDataRepositoryImp @Inject constructor (
    private val trendingTvShowPagingSource: TrendingTvShowPagingSource,
    private val topRatedTvShowPagingSource: TopRatedTvShowPagingSource,
    private val popularTvShowPagingSource: PopularTvShowPagingSource,
    private val similarTvShowPagingSourceFactory: SimilarTvShowPagingSource.SimilarTvShowPagingSourceFactory,
    private val searchTvShowPagingSourceFactory: SearchTvShowPagingSource.SearchTvShowPagingSourceFactory,
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

    override fun getPagingSimilarTvShow(tvShowId : String): Flow<PagingData<TvShow>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { similarTvShowPagingSourceFactory.create(tvShowId) }
        ).flow
    }

    override fun getPagingSearchTvShow(tvShowSearch : String): Flow<PagingData<TvShow>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { searchTvShowPagingSourceFactory.create(tvShowSearch) }
        ).flow
    }


}