package com.codeinglogs.data.model.tvshow.tvshowlist

import com.codeinglogs.domain.model.tvshow.tvshowslist.TvShow as DomainResultTrendingTvShow

data class TvShow(

    val id: Int,
    val name: String,
    val original_name: String,
    val overview: String,
    val poster_path: String,
    val vote_average: Double,
)

fun TvShow.toDomainTrendingTvShowResult()=DomainResultTrendingTvShow(
    id=id,
    name=name,
    poster_path=poster_path,
    vote_average=vote_average,
    original_name=original_name,
    overview=overview,

)