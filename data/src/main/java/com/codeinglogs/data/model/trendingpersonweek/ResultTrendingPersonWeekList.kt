package com.codeinglogs.data.model.trendingpersonweek


import com.codeinglogs.domain.model.trendingpersonweek.ResultTrendingPersonWeekList as DomainResultTrendingPersonWeekList

data class ResultTrendingPersonWeekList(
    val name: String,
    val id: Int,
    val profile_path:String
)

fun ResultTrendingPersonWeekList.toDomainResultTrendingPersonWeekList()=DomainResultTrendingPersonWeekList(
    name=name,
    profile_path=profile_path,
    id=id
)


