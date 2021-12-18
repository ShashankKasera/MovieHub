package com.codeinglogs.domain.model.tvshow.tvshowslist

data class TvShowsListResponce(
    val page: Int,
    val results: List<TvShow>,
    val total_pages: Int,
    val total_results: Int
)