package com.codeinglogs.domain.model.tvshow.tvshowdetails.similar

data class TvShowSimilarResponse(
    val page: Int,
    val results: List<TvShowSimilar>,
    val total_pages: Int,
    val total_results: Int
)