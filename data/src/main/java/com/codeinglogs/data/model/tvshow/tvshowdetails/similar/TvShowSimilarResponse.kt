package com.codeinglogs.data.model.tvshow.tvshowdetails.similar

import com.codeinglogs.data.model.tvshow.tvshowlist.TvShow
import com.codeinglogs.data.model.tvshow.tvshowlist.toDomainTvShows
import com.codeinglogs.domain.model.tvshow.tvshowdetails.similar.TvShowSimilarResponse as DomainTvShowSimilarResponse

data class TvShowSimilarResponse(
    val page: Int,
    val results: List<TvShow>,
    val total_pages: Int,
    val total_results: Int
)

fun TvShowSimilarResponse.toDomainTvShowSimilarResponse()=DomainTvShowSimilarResponse(
    page=page,
    results=results.toDomainTvShows(),
    total_pages=total_pages,
    total_results=total_results
)
