package com.codeinglogs.presentation.model.trendingpersonweek

import com.codeinglogs.domain.model.trendingpersonweek.TrendingPersonWeekList as DomainTrendingPersonWeekList
import com.codeinglogs.domain.model.trendingpersonweek.ResultTrendingPersonWeekList as DomainResultTrendingPersonWeek

data class TrendingPersonWeekList(
    val page: Int,
    val resultTrendingPersonWeekLists: List<ResultTrendingPersonWeekList>,
    val total_pages: Int,
    val total_results: Int
)

fun DomainTrendingPersonWeekList.toPresentationTrendingPersonWeekList()=TrendingPersonWeekList(

    page=page,
    resultTrendingPersonWeekLists=resultTrendingPersonWeekLists.toPresentationResultTrendingPersonWeekList(),
    total_pages=total_pages,
    total_results=total_results
)

fun List<DomainResultTrendingPersonWeek>.toPresentationResultTrendingPersonWeekList():List<ResultTrendingPersonWeekList>{
    val list = mutableListOf<ResultTrendingPersonWeekList>()
    this.forEach { list.add(it.toPresentationResultTrendingPersonWeekList()) }
    return list
}