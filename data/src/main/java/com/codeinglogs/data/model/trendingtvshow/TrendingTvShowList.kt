package com.codeinglogs.data.model.trendingtvshow

import com.codeinglogs.domain.model.trendingtvshow.TrendingTvShowList as DomainTrendingTvShowList
import com.codeinglogs.domain.model.trendingtvshow.ResultTrendingTvShow as DomainResultTrendingTvShow
data class TrendingTvShowList(
    val page: Int,
    val resultTrendingTvShows: List<ResultTrendingTvShow>,
    val total_pages: Int,
    val total_results: Int
)

fun TrendingTvShowList.toDomainTrendingTvShowList()=DomainTrendingTvShowList(
    page=page,
    resultTrendingTvShows=resultTrendingTvShows.toDomainTrendingTvShowResultList(),
    total_pages=total_pages,
    total_results=total_results
)

fun List<ResultTrendingTvShow>.toDomainTrendingTvShowResultList():List<DomainResultTrendingTvShow>{

    val list= mutableListOf<DomainResultTrendingTvShow>()
    this.forEach { list.add(it.toDomainTrendingTvShowResult()) }
    return list
}