package com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasonimage

import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasonimage.TvShowSeasonPoster as DomainTvShowSeasonPoster
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasonimage.TvShowSeasonImageResponse as DomainTvShowSeasonImageResponse

data class TvShowSeasonImageResponse(
    val id: Int,
    val posters: List<TvShowSeasonPoster>
)

fun TvShowSeasonImageResponse.toDomainTvShowSeasonImageResponse()= DomainTvShowSeasonImageResponse(
    id=id,
    posters = posters.toDomainTvShowSeasonPoster()
)

fun List<TvShowSeasonPoster>.toDomainTvShowSeasonPoster():List<DomainTvShowSeasonPoster>{
    val list= mutableListOf<DomainTvShowSeasonPoster>()
    this.forEach { list.add(it.toDomainTvShowSeasonPoster()) }
    return list
}