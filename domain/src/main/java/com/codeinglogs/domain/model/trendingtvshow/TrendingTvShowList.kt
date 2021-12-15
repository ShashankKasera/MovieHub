package com.codeinglogs.domain.model.trendingtvshow

data class TrendingTvShowList(
    val page: Int,
    val resultTrendingTvShows: List<ResultTrendingTvShow>,
    val total_pages: Int,
    val total_results: Int
)