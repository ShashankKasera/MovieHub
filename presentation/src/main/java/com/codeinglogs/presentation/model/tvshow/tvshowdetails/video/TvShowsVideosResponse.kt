package com.codeinglogs.presentation.model.tvshow.tvshowdetails.video

import com.codeinglogs.domain.model.tvshow.tvshowdetails.video.TvShowsVideos as DomainTvShowsVideos
import com.codeinglogs.domain.model.tvshow.tvshowdetails.video.TvShowsVideosResponse as DomainTvShowsVideosResponse

data class TvShowsVideosResponse(
    val id: Int,
    val results: List<TvShowsVideos>
)

fun DomainTvShowsVideosResponse.toPresentationTvShowsVideosResponse()= TvShowsVideosResponse(
    id=id,
    results = results.toPresentationTvShowsVideos()
)

fun List<DomainTvShowsVideos>.toPresentationTvShowsVideos():List<TvShowsVideos>{
    val list= mutableListOf<TvShowsVideos>()
    this.forEach { list.add(it.toPresentationTvShowsVideos()) }
    return list
}