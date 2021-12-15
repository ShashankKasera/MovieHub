package com.codeinglogs.remote.datarepositoryimp

import androidx.paging.*
import com.codeinglogs.data.model.State
import com.codeinglogs.data.model.trendingpersonweek.ResultTrendingPersonWeekList
import com.codeinglogs.data.model.trendingpersonweek.TrendingPersonWeekList
import com.codeinglogs.data.repository.trendingpersonweek.RemoteTrendingPersonWeekData
import com.codeinglogs.remote.model.trendingpersonweek.toDataTrendingPersonWeekList
import com.codeinglogs.remote.pagingsource.TrendingPersonWeekPagingSource
import com.codeinglogs.remote.request.TrendingPersonWeekRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TrendingPersonWeekDataRepositoryImp @Inject constructor
    (
        private val trendingPersonWeekRequest: TrendingPersonWeekRequest,
        private val trendingPersonWeekPagingSource: TrendingPersonWeekPagingSource
    ) :
    RemoteTrendingPersonWeekData {

    override fun getTrendingPersonWeek(): Flow<State<TrendingPersonWeekList>> = flow <State<TrendingPersonWeekList>>{
        emit(State.loading())
        val trendingPersonWeek = trendingPersonWeekRequest.getTrendingPersonWeek()
        emit(State.success(trendingPersonWeek.toDataTrendingPersonWeekList()))
    }.catch {
        emit(State.failed(it.message?:""))
    }

    override fun getPagingTrendingPersonWeek(): Flow<PagingData<ResultTrendingPersonWeekList>> {
         return Pager(
             config = PagingConfig(
                 pageSize = 20,
                 maxSize = 100,
                 enablePlaceholders = false
             ),
             pagingSourceFactory = { trendingPersonWeekPagingSource }
         ).flow
    }
}