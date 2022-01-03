package com.codeinglogs.presentation.model.tvshow.tvshowdetails.video
import com.codeinglogs.domain.model.tvshow.tvshowdetails.video.TvShowsVideos as DomainTvShowsVideos

data class TvShowsVideos(
    val id: String,
    val key: String,
    val name: String,
)
fun DomainTvShowsVideos.toPresentationTvShowsVideos()= TvShowsVideos(
    id = id,
    key = key,
    name = name,
)