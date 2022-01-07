package com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasonvideo

import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasonvideo.TvShowsSeasonVideos as DomainTvShowsSeasonVideos
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasonvideo.TvShowsSeasonVideosResponse as DomainTvShowsSeasonVideosResponse

data class TvShowsSeasonVideosResponse(
    val id: Int,
    val results: List<TvShowsSeasonVideos>
)

fun TvShowsSeasonVideosResponse.toDomainTvShowsSeasonVideosResponse()= DomainTvShowsSeasonVideosResponse(
    id=id,
    results = results.toDomainTvShowsSeasonVideos()
)

fun List<TvShowsSeasonVideos>.toDomainTvShowsSeasonVideos():List<DomainTvShowsSeasonVideos>{
    val list= mutableListOf<DomainTvShowsSeasonVideos>()
    this.forEach { list.add(it.toDomainTvShowsSeasonVideos()) }
    return list
}