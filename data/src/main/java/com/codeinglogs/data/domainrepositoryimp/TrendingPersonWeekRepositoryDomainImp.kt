package com.codeinglogs.data.domainrepositoryimp


import androidx.paging.map
import com.codeinglogs.data.maper.toDomainState
import com.codeinglogs.data.model.trendingpersonweek.toDomainResultTrendingPersonWeekList
import com.codeinglogs.data.store.trendingpersonweek.TrendingPersonWeekDataSore
import com.codeinglogs.domain.repository.TrendingPersonWeekRepositoryDomain
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TrendingPersonWeekRepositoryDomainImp @Inject constructor (private val trendingPersonWeekDataSore : TrendingPersonWeekDataSore) :
    TrendingPersonWeekRepositoryDomain {

    override fun getTrendingPersonWeek() =
        trendingPersonWeekDataSore.getRemoteDataSource()
            .getTrendingPersonWeek().map { it.toDomainState() }


    override fun getPagingTrendingPersonWeek() =
        trendingPersonWeekDataSore.getRemoteDataSource()
            .getPagingTrendingPersonWeek().map { it -> it.map { it.toDomainResultTrendingPersonWeekList() } }

}