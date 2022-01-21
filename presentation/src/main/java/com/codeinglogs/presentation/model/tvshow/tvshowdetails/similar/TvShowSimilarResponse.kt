package com.codeinglogs.presentation.model.tvshow.tvshowdetails.similar
import com.codeinglogs.presentation.model.tvshow.tvshowslist.TvShow
import com.codeinglogs.presentation.model.tvshow.tvshowslist.toPresentationTvShow
import com.codeinglogs.domain.model.tvshow.tvshowdetails.similar.TvShowSimilarResponse as DomainTvShowSimilarResponse

data class TvShowSimilarResponse(
    val page: Int,
    val results: List<TvShow>,
    val total_pages: Int,
    val total_results: Int
)

fun DomainTvShowSimilarResponse.toPresentationTvShowSimilarResponse()=TvShowSimilarResponse(
    page=page,
    results=results.toPresentationTvShow(),
    total_pages=total_pages,
    total_results=total_results
)
