package com.codeinglogs.presentation.model.tvshow.tvshowseasondetails.seasonvideo

import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasonvideo.TvShowsSeasonVideos as DomainTvShowsSeasonVideos
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasonvideo.TvShowsSeasonVideosResponse as DomainTvShowsSeasonVideosResponse

data class TvShowsSeasonVideosResponse(
    val id: Int,
    val results: List<TvShowsSeasonVideos>
)

fun DomainTvShowsSeasonVideosResponse.toPresentationTvShowsSeasonVideosResponse()= TvShowsSeasonVideosResponse(
    id=id,
    results = results.toPresentationTvShowsSeasonVideos()
)

fun List<DomainTvShowsSeasonVideos>.toPresentationTvShowsSeasonVideos():List<TvShowsSeasonVideos>{
    val list= mutableListOf<TvShowsSeasonVideos>()
    this.forEach { list.add(it.toPresentationTvShowsSeasonVideos()) }
    return list
}