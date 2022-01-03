package com.codeinglogs.data.model.tvshow.tvshowdetails.credits

import com.codeinglogs.domain.model.tvshow.tvshowdetails.credits.TvShowCast as DomainTvShowCast
import com.codeinglogs.domain.model.tvshow.tvshowdetails.credits.TvShowCrew as DomainTvShowCrew
import com.codeinglogs.domain.model.tvshow.tvshowdetails.credits.TvShowCreditsResponse as domainTvShowCreditsResponse


data class TvShowCreditsResponse(
    val cast: List<TvShowCast>,
    val crew: List<TvShowCrew>,
    val id: Int
)


fun TvShowCreditsResponse.toDomainTvShowCreditsResponse()= domainTvShowCreditsResponse(
    cast=cast.toDomainTvShowCast(),
    crew=crew.toDomainTvShowCrew(),
    id=id
)

fun List<TvShowCast>.toDomainTvShowCast():List<DomainTvShowCast>{
    val list= mutableListOf<DomainTvShowCast>()
    this.forEach { list.add(it.toDomainTvShowCast()) }
    return list
}

fun List<TvShowCrew>.toDomainTvShowCrew():List<DomainTvShowCrew>{
    val list= mutableListOf<DomainTvShowCrew>()
    this.forEach { list.add(it.toDomainTvShowCrew()) }
    return list
}