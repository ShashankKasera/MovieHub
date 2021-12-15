package com.codeinglogs.remote.model.trendingpersonweek

import com.codeinglogs.data.model.trendingpersonweek.ResultTrendingPersonWeekList as DataResultTrendingPersonWeekList

data class Result(
    val adult: Boolean?,
    val gender: Int?,
    val id: Int?,
    val known_for_department: String?,
    val media_type: String?,
    val name: String?,
    val popularity: Double?,
    val profile_path: String
)

fun Result.toDataTrendingPersonWeekResult()=DataResultTrendingPersonWeekList(
    name=name?:"",
    profile_path=profile_path?:"",
    id=id?:0
)
