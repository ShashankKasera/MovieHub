package com.codeinglogs.domain.model.trendingpersonweek


data class TrendingPersonWeekList(
    val page: Int,
    val resultTrendingPersonWeekLists: List<ResultTrendingPersonWeekList>,
    val total_pages: Int,
    val total_results: Int
)
