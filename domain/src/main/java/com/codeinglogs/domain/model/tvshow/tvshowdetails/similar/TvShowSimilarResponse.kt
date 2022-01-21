package com.codeinglogs.domain.model.tvshow.tvshowdetails.similar

import com.codeinglogs.domain.model.tvshow.tvshowslist.TvShow

data class TvShowSimilarResponse(
    val page: Int,
    val results: List<TvShow>,
    val total_pages: Int,
    val total_results: Int
)