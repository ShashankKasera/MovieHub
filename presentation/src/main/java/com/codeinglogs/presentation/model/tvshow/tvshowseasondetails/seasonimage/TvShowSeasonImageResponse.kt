package com.codeinglogs.presentation.model.tvshow.tvshowseasondetails.seasonimage

import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasonimage.TvShowSeasonPoster as DomainTvShowSeasonPoster
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasonimage.TvShowSeasonImageResponse as DomainTvShowSeasonImageResponse

data class TvShowSeasonImageResponse(
    val id: Int,
    val posters: List<TvShowSeasonPoster>
)

fun DomainTvShowSeasonImageResponse.toPresentationTvShowSeasonImageResponse()= TvShowSeasonImageResponse(
    id=id,
    posters = posters.toPresentationTvShowSeasonPoster()
)



fun List<DomainTvShowSeasonPoster>.toPresentationTvShowSeasonPoster():List<TvShowSeasonPoster>{
    val list= mutableListOf<TvShowSeasonPoster>()
    this.forEach { list.add(it.toPresentationTvShowSeasonPoster()) }
    return list
}