package com.codeinglogs.remote.model.tvshows.tvshowdetails.similar

import com.codeinglogs.remote.model.tvshows.tvshowslist.TvShows
import com.codeinglogs.remote.model.tvshows.tvshowslist.toDataTvShow
import com.codeinglogs.data.model.tvshow.tvshowdetails.similar.TvShowSimilarResponse as DataTvShowSimilarResponse

data class TvShowSimilarResponse(
    val page: Int?,
    val results: List<TvShows>?,
    val total_pages: Int?,
    val total_results: Int?
)

fun TvShowSimilarResponse.toDataTvShowSimilarResponse()=DataTvShowSimilarResponse(
    page =page?:0,
    results =results?.toDataTvShow()?: listOf(),
    total_pages =total_pages?:0,
    total_results =total_results?:0
)