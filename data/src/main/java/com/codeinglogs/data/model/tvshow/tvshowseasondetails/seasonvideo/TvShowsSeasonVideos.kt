package com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasonvideo
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasonvideo.TvShowsSeasonVideos as DomainTvShowsSeasonVideos

data class TvShowsSeasonVideos(
    val id: String,
    val key: String,
    val name: String,
)

fun TvShowsSeasonVideos.toDomainTvShowsSeasonVideos()= DomainTvShowsSeasonVideos(
    id = id,
    key = key,
    name = name,
)