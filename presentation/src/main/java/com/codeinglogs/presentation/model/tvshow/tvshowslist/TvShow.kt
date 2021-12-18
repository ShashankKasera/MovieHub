package com.codeinglogs.presentation.model.tvshow.tvshowslist

import com.codeinglogs.domain.model.tvshow.tvshowslist.TvShow as DomainResultTrendingTvShow


data class TvShow(
    val id: Int,
    val name: String,
    val original_name: String,
    val overview: String,
    val poster_path: String,
    val vote_average:Double,
)

fun DomainResultTrendingTvShow.toPresentationTvShow()=TvShow(
    id=id,
    vote_average=vote_average,
    name=name,
    poster_path=poster_path,
    original_name=original_name,
    overview=overview,
)