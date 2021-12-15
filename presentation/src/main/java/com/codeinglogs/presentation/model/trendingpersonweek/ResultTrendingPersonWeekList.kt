package com.codeinglogs.presentation.model.trendingpersonweek

import com.codeinglogs.domain.model.trendingpersonweek.ResultTrendingPersonWeekList as DomainResultTrendingPersonWeekList

data class ResultTrendingPersonWeekList(
    val name: String,
    val profile_path:String,
    val id:Int
)

fun DomainResultTrendingPersonWeekList.toPresentationResultTrendingPersonWeekList()=ResultTrendingPersonWeekList(
    name=name,
    profile_path=profile_path,
    id=id
)

