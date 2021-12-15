package com.codeinglogs.remote.model.trendingtvshow

import com.codeinglogs.data.model.trendingtvshow.TrendingTvShowList as DataTrendingTvShowList
import com.codeinglogs.data.model.trendingtvshow.ResultTrendingTvShow as DataResultTrendingTvShow
data class TrendingTvShowList(
    val page: Int?,
    val results: List<ResultTrendingTvShow>?,
    val total_pages: Int?,
    val total_results: Int?
)

fun TrendingTvShowList.dataTrendingMoviesList()=DataTrendingTvShowList(

    page=page?:0,
    resultTrendingTvShows = results?.dataResultTrendingTvShow()?: listOf(),
    total_pages=total_pages?:0,
    total_results=total_results?:0
)
fun List<ResultTrendingTvShow>.dataResultTrendingTvShow():List<DataResultTrendingTvShow>{
    val list= mutableListOf<DataResultTrendingTvShow>()
    this.forEach { list.add(it.toDataTrendingTvShowResult()) }
    return list
}