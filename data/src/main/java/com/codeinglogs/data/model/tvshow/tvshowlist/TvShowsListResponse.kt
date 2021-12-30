package com.codeinglogs.data.model.tvshow.tvshowlist

import com.codeinglogs.domain.model.tvshow.tvshowslist.TvShowsListResponse as DomainTvShowsListResponse
import com.codeinglogs.domain.model.tvshow.tvshowslist.TvShow as DomainTvShow
data class TvShowsListResponse(
    val page: Int?=null,
    val results: List<TvShow>,
    val total_pages: Int?=null,
    val total_results: Int?=null
)

fun TvShowsListResponse.toDomainTvShowsListResponse()=DomainTvShowsListResponse(
    page=page,
    results =results.toDomainTvShows(),
    total_pages=total_pages,
    total_results=total_results
)

fun List<TvShow>.toDomainTvShows():List<DomainTvShow>{

    val list= mutableListOf<DomainTvShow>()
    this.forEach { list.add(it.toDomainTrendingTvShowResult()) }
    return list
}