package com.codeinglogs.presentation.model.tvshow.tvshowslist

import com.codeinglogs.domain.model.tvshow.tvshowslist.TvShowsListResponse as DomainTvShowsListResponse
import com.codeinglogs.domain.model.tvshow.tvshowslist.TvShow as DomainTvShow

data class TvShowsListResponse(
    val page: Int?=null,
    val results: List<TvShow>,
    val total_pages: Int?=null,
    val total_results: Int?=null
)

fun DomainTvShowsListResponse.toPresentationTvShowsListResponse()=TvShowsListResponse(
    page=page,
    results=results.toPresentationTvShow(),
    total_pages=total_pages,
    total_results=total_results
)

fun List<DomainTvShow>.toPresentationTvShow():List<TvShow>{
    val list= mutableListOf<TvShow>()
    this.forEach { list.add(it.toPresentationTvShow()) }
    return list
}