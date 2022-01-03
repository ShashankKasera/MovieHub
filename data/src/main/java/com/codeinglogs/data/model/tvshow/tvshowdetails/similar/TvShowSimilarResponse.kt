package com.codeinglogs.data.model.tvshow.tvshowdetails.similar

import com.codeinglogs.domain.model.tvshow.tvshowdetails.similar.TvShowSimilar as DomainTvShowSimilar
import com.codeinglogs.domain.model.tvshow.tvshowdetails.similar.TvShowSimilarResponse as DomainTvShowSimilarResponse

data class TvShowSimilarResponse(
    val page: Int,
    val results: List<TvShowSimilar>,
    val total_pages: Int,
    val total_results: Int
)

fun TvShowSimilarResponse.toDomainTvShowSimilarResponse()=DomainTvShowSimilarResponse(
    page=page,
    results=results.toDomainTvShowSimilar(),
    total_pages=total_pages,
    total_results=total_results
)

fun List<TvShowSimilar>.toDomainTvShowSimilar():List<DomainTvShowSimilar>{
    val list= mutableListOf<DomainTvShowSimilar>()
    this.forEach { list.add(it.toDomainTvShowSimilar()) }
    return list
}