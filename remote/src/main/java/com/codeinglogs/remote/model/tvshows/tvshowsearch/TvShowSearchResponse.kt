package com.codeinglogs.remote.model.tvshows.tvshowsearch

import com.codeinglogs.remote.model.tvshows.tvshowslist.TvShows

data class TvShowSearchResponse (
    val page: Int?,
    val results: List<TvShows>?,
    val total_pages: Int?,
    val total_results: Int?
)