package com.codeinglogs.presentation.model.tvshow.tvshowseasondetails.seasonvideo
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasonvideo.TvShowsSeasonVideos as DomainTvShowsSeasonVideos

data class TvShowsSeasonVideos(
    val id: String,
    val key: String,
    val name: String,
)

fun DomainTvShowsSeasonVideos.toPresentationTvShowsSeasonVideos()= TvShowsSeasonVideos(
    id = id,
    key = key,
    name = name,
)