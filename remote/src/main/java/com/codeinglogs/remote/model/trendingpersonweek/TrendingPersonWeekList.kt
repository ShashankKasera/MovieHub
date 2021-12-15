package com.codeinglogs.remote.model.trendingpersonweek


import com.codeinglogs.data.model.trendingpersonweek.TrendingPersonWeekList as DataTrendingPersonWeekList
import com.codeinglogs.data.model.trendingpersonweek.ResultTrendingPersonWeekList as DataResultTrendingPersonWeekList


data class TrendingPersonWeekList(
    val page: Int?,
    val results: List<Result>,
    val total_pages: Int?,
    val total_results: Int?
)

fun TrendingPersonWeekList.toDataTrendingPersonWeekList()=DataTrendingPersonWeekList(
    page=page?:0,
    total_pages=total_pages?:0,
    total_results=total_results?:0,
    resultTrendingPersonWeekLists=results.toDataTrendingPersonWeekResultList()
)
fun List<Result>.toDataTrendingPersonWeekResultList() : List<DataResultTrendingPersonWeekList>{
    val list = mutableListOf<DataResultTrendingPersonWeekList>()
    this.forEach { list.add(it.toDataTrendingPersonWeekResult()) }
    return list
}
