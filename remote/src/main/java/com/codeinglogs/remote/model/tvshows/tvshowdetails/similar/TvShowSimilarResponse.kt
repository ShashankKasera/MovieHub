package com.codeinglogs.remote.model.tvshows.tvshowdetails.similar

import com.codeinglogs.data.model.tvshow.tvshowdetails.similar.TvShowSimilar as DataTvShowSimilar
import com.codeinglogs.data.model.tvshow.tvshowdetails.similar.TvShowSimilarResponse as DataTvShowSimilarResponse

data class TvShowSimilarResponse(
    val page: Int?,
    val results: List<TvShowSimilar>?,
    val total_pages: Int?,
    val total_results: Int?
)

fun TvShowSimilarResponse.toDataTvShowSimilarResponse()=DataTvShowSimilarResponse(
    page =page?:0,
    results =results?.toDataTvShowSimilar()?: listOf(),
    total_pages =total_pages?:0,
    total_results =total_results?:0
)

fun List<TvShowSimilar>.toDataTvShowSimilar():List<DataTvShowSimilar>{
    val list= mutableListOf<DataTvShowSimilar>()
    this.forEach { list.add(it.toDataTvShowSimilar()) }
    return list
}