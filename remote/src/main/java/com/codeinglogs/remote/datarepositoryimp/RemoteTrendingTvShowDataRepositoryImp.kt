package com.codeinglogs.remote.datarepositoryimp

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.tvshow.tvshowlist.TvShow
import com.codeinglogs.data.model.tvshow.tvshowlist.TvShowsListResponse
import com.codeinglogs.data.repository.trendingtvshow.RemoteTrendingTvShowData
import com.codeinglogs.remote.model.tvshows.tvshowslist.toDataTvShowsListResponse
import com.codeinglogs.remote.pagingsource.TrendingMoviePagingSource
import com.codeinglogs.remote.pagingsource.TrendingTvShowPagingSource
import com.codeinglogs.remote.request.TvShowRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

private const val TAG = "123MainActivity"
class RemoteTrendingTvShowDataRepositoryImp @Inject constructor (
    private val tvShowRequest: TvShowRequest,
    private val trendingTvShowPagingSource: TrendingTvShowPagingSource
    ) :
    RemoteTrendingTvShowData {
    override fun getTrendingTvShow(): Flow<State<TvShowsListResponse>> = flow <State<TvShowsListResponse>>{
        emit(State.loading())
        val trendingTvShow = tvShowRequest.getTrendingTvShow()
        Log.i(TAG, "repo: ${trendingTvShow}")
        emit(State.success(trendingTvShow.toDataTvShowsListResponse()))
    }.catch {
        emit(State.failed(it.message?:""))
    }

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

}