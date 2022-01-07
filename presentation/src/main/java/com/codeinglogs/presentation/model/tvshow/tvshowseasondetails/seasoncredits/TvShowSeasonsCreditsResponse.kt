package com.codeinglogs.presentation.model.tvshow.tvshowseasondetails.seasoncredits

import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasoncredits.TvShowSeasonsCrew as DomainTvShowSeasonsCrew
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasoncredits.TvShowSeasonsCast as DomainTvShowSeasonsCast
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasoncredits.TvShowSeasonsCreditsResponse as DomainTvShowSeasonsCreditsResponse


data class TvShowSeasonsCreditsResponse(
    val cast: List<TvShowSeasonsCast>,
    val crew: List<TvShowSeasonsCrew>,
    val id: Int
)

fun DomainTvShowSeasonsCreditsResponse.toPresentationTvShowSeasonsCreditsResponse()= TvShowSeasonsCreditsResponse(
    cast=cast.toPresentationTvShowSeasonsCast(),
    crew=crew.toPresentationTvShowSeasonsCrew(),
    id=id
)

fun List<DomainTvShowSeasonsCrew>.toPresentationTvShowSeasonsCrew():List<TvShowSeasonsCrew>{
    val list= mutableListOf<TvShowSeasonsCrew>()
    this.forEach { list.add(it.toPresentationTvShowSeasonsCrew()) }
    return list
}

fun List<DomainTvShowSeasonsCast>.toPresentationTvShowSeasonsCast():List<TvShowSeasonsCast>{
    val list= mutableListOf<TvShowSeasonsCast>()
    this.forEach { list.add(it.toPresentationTvShowSeasonsCast()) }
    return list
}