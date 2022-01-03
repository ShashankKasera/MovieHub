package com.codeinglogs.presentation.model.tvshow.tvshowdetails.similar

import com.codeinglogs.domain.model.tvshow.tvshowdetails.similar.TvShowSimilar as DomainTvShowSimilar

data class TvShowSimilar(

    val backdrop_path: String,
    val first_air_date: String,
    val id: Int,
    val name: String,
    val vote_average: Double,
)
fun DomainTvShowSimilar.toPresentationTvShowSimilar()= TvShowSimilar(
    backdrop_path=backdrop_path,
    first_air_date=first_air_date,
    id=id,
    name=name,
    vote_average=vote_average
)