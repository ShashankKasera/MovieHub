package com.codeinglogs.presentation.model.trendingtvshow

import com.codeinglogs.domain.model.trendingtvshow.TrendingTvShowList as DomainTrendingTvShowList
import com.codeinglogs.domain.model.trendingtvshow.ResultTrendingTvShow as DomainResultTrendingTvShow

data class TrendingTvShowList(
    val page: Int,
    val resultTrendingTvShows: List<ResultTrendingTvShow>,
    val total_pages: Int,
    val total_results: Int
)

fun DomainTrendingTvShowList.toPresentationTrendingTvShowList()=TrendingTvShowList(
    page=page,
    resultTrendingTvShows=resultTrendingTvShows.toPresentationTrendingTvShowResultList(),
    total_pages=total_pages,
    total_results=total_results
)

fun List<DomainResultTrendingTvShow>.toPresentationTrendingTvShowResultList():List<ResultTrendingTvShow>{
    val list= mutableListOf<ResultTrendingTvShow>()
    this.forEach { list.add(it.toPresentationTrendingTvShowResult()) }
    return list
}