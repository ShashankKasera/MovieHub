package com.codeinglogs.presentation.model.tvshow.tvshowdetails.similar
import com.codeinglogs.domain.model.tvshow.tvshowdetails.similar.TvShowSimilar as DomainTvShowSimilar
import com.codeinglogs.domain.model.tvshow.tvshowdetails.similar.TvShowSimilarResponse as DomainTvShowSimilarResponse

data class TvShowSimilarResponse(
    val page: Int,
    val results: List<TvShowSimilar>,
    val total_pages: Int,
    val total_results: Int
)

fun DomainTvShowSimilarResponse.toPresentationTvShowSimilarResponse()=TvShowSimilarResponse(
    page=page,
    results=results.toPresentationTvShowSimilar(),
    total_pages=total_pages,
    total_results=total_results
)

fun List<DomainTvShowSimilar>.toPresentationTvShowSimilar():List<TvShowSimilar>{
    val list= mutableListOf<TvShowSimilar>()
    this.forEach { list.add(it.toPresentationTvShowSimilar()) }
    return list
}