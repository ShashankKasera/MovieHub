package com.codeinglogs.presentation.model.tvshow.tvshowslist

import com.codeinglogs.domain.model.tvshow.tvshowslist.TvShow as DomainResultTrendingTvShow


data class TvShow(
    val id: Long,
    val name: String,
    val original_name: String,
    val overview: String,
    val first_air_date: String,
    val poster_path: String,
    val backdrop_path: String,
    val vote_average:Double,
)

fun DomainResultTrendingTvShow.toPresentationTvShow()=TvShow(
    id=id,
    vote_average=vote_average,
    name=name,
    first_air_date=first_air_date,
    poster_path=poster_path,
    backdrop_path=backdrop_path,
    original_name=original_name,
    overview=overview,
)