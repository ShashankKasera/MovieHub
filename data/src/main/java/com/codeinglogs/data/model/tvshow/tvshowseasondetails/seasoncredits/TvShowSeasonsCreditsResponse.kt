package com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasoncredits

import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasoncredits.TvShowSeasonsCrew as DomainTvShowSeasonsCrew
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasoncredits.TvShowSeasonsCast as DomainTvShowSeasonsCast
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasoncredits.TvShowSeasonsCreditsResponse as DomainTvShowSeasonsCreditsResponse


data class TvShowSeasonsCreditsResponse(
    val cast: List<TvShowSeasonsCast>,
    val crew: List<TvShowSeasonsCrew>,
    val id: Int
)

fun TvShowSeasonsCreditsResponse.toDomainTvShowSeasonsCreditsResponse()= DomainTvShowSeasonsCreditsResponse(
    cast=cast.toDomainTvShowSeasonsCast(),
    crew=crew.toDomainTvShowSeasonsCrew(),
    id=id
)

fun List<TvShowSeasonsCrew>.toDomainTvShowSeasonsCrew():List<DomainTvShowSeasonsCrew>{
    val list= mutableListOf<DomainTvShowSeasonsCrew>()
    this.forEach { list.add(it.toDomainTvShowSeasonsCrew()) }
    return list
}

fun List<TvShowSeasonsCast>.toDomainTvShowSeasonsCast():List<DomainTvShowSeasonsCast>{
    val list= mutableListOf<DomainTvShowSeasonsCast>()
    this.forEach { list.add(it.toDomainTvShowSeasonsCast()) }
    return list
}

