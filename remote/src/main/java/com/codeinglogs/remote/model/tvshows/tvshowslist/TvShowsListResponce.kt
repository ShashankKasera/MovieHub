package com.codeinglogs.remote.model.tvshows.tvshowslist

import com.codeinglogs.data.model.tvshow.tvshowlist.TvShowsListResponce as DataTvShowsListResponce
import com.codeinglogs.data.model.tvshow.tvshowlist.TvShow as DataTvShow
data class TvShowsListResponce(
    val page: Int?,
    val results: List<TvShows>?,
    val total_pages: Int?,
    val total_results: Int?
)

fun TvShowsListResponce.toDataTvShowsListResponce()=DataTvShowsListResponce(

    page=page?:0,
    results = results?.toDataTvShow()?: listOf(),
    total_pages=total_pages?:0,
    total_results=total_results?:0
)
fun List<TvShows>.toDataTvShow():List<DataTvShow>{
    val list= mutableListOf<DataTvShow>()
    this.forEach { list.add(it.toDataTvShow()) }
    return list
}