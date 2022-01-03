package com.codeinglogs.presentation.model.tvshow.tvshowdetails.credits

import com.codeinglogs.domain.model.tvshow.tvshowdetails.credits.TvShowCast as DomainTvShowCast
import com.codeinglogs.domain.model.tvshow.tvshowdetails.credits.TvShowCrew as DomainTvShowCrew
import com.codeinglogs.domain.model.tvshow.tvshowdetails.credits.TvShowCreditsResponse as DomainTvShowCreditsResponse

data class TvShowCreditsResponse(
    val cast: List<TvShowCast>,
    val crew: List<TvShowCrew>,
    val id: Int
)

fun DomainTvShowCreditsResponse.toPresentationTvShowCreditsResponse()= TvShowCreditsResponse(
    cast=cast.toPresentationTvShowCast(),
    crew=crew.toPresentationTvShowCrew(),
    id=id
)

fun List<DomainTvShowCast>.toPresentationTvShowCast():List<TvShowCast>{
    val list= mutableListOf<TvShowCast>()
    this.forEach { list.add(it.toPresentationTvShowCast()) }
    return list
}

fun List<DomainTvShowCrew>.toPresentationTvShowCrew():List<TvShowCrew>{
    val list= mutableListOf<TvShowCrew>()
    this.forEach { list.add(it.toPresentationTvShowCrew()) }
    return list
}