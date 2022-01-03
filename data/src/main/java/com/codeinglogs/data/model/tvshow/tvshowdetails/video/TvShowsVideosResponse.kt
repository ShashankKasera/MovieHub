package com.codeinglogs.data.model.tvshow.tvshowdetails.video

import com.codeinglogs.domain.model.tvshow.tvshowdetails.video.TvShowsVideos as DomainTvShowsVideos
import com.codeinglogs.domain.model.tvshow.tvshowdetails.video.TvShowsVideosResponse as DomainTvShowsVideosResponse

data class TvShowsVideosResponse(
    val id: Int,
    val results: List<TvShowsVideos>
)

fun TvShowsVideosResponse.toDomainTvShowsVideosResponse()= DomainTvShowsVideosResponse(
    id=id,
    results = results.toDomainTvShowsVideos()
)

fun List<TvShowsVideos>.toDomainTvShowsVideos():List<DomainTvShowsVideos>{
    val list= mutableListOf<DomainTvShowsVideos>()
    this.forEach { list.add(it.toDomainTvShowsVideos()) }
    return list
}