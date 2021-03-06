package com.codeinglogs.domain.model.tvshow.tvshowslist

data class TvShowsListResponse(
    val page: Int?=null,
    val results: List<TvShow>,
    val total_pages: Int?=null,
    val total_results: Int?=null
)