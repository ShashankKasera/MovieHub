package com.codeinglogs.data.model.trendingpersonweek

import com.codeinglogs.domain.model.trendingpersonweek.TrendingPersonWeekList as DomainTrendingPersonWeekList
import com.codeinglogs.domain.model.trendingpersonweek.ResultTrendingPersonWeekList as DomainResultTrendingPersonWeek

data class TrendingPersonWeekList(
    val page: Int,
    val resultTrendingPersonWeekLists: List<ResultTrendingPersonWeekList>,
    val total_pages: Int,
    val total_results: Int
)

fun TrendingPersonWeekList.toDomainTrendingPersonWeekList()=DomainTrendingPersonWeekList(

    page=page,
    resultTrendingPersonWeekLists=resultTrendingPersonWeekLists.toDomainResultTrendingPersonWeekList(),
    total_pages=total_pages,
    total_results=total_results
)

fun List<ResultTrendingPersonWeekList>.toDomainResultTrendingPersonWeekList():List<DomainResultTrendingPersonWeek>{
    val list = mutableListOf<DomainResultTrendingPersonWeek>()
    this.forEach { list.add(it.toDomainResultTrendingPersonWeekList()) }
    return list
}