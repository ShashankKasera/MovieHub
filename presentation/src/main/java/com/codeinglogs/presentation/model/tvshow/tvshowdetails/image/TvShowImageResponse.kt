package com.codeinglogs.presentation.model.tvshow.tvshowdetails.image

import com.codeinglogs.domain.model.tvshow.tvshowdetails.image.TvShowBackdrop as DomainTvShowBackdrop
import com.codeinglogs.domain.model.tvshow.tvshowdetails.image.TvShowPoster as DomainTvShowPoster
import com.codeinglogs.domain.model.tvshow.tvshowdetails.image.TvShowImageResponse as DomainTvShowImageResponse

data class TvShowImageResponse(
    val backdrops: List<TvShowBackdrop>,
    val id: Int,
    val posters: List<TvShowPoster>
)


fun  DomainTvShowImageResponse.toPresentationTvShowImageResponse()= TvShowImageResponse(
    id=id,
    backdrops = backdrops.toPresentationTvShowBackdrop(),
    posters = posters.toPresentationTvShowPoster()
)

fun List<DomainTvShowBackdrop>.toPresentationTvShowBackdrop():List<TvShowBackdrop>{
    val list= mutableListOf<TvShowBackdrop>()
    this.forEach { list.add(it.toPresentationTvShowBackdrop()) }
    return list
}

fun List<DomainTvShowPoster>.toPresentationTvShowPoster():List<TvShowPoster>{
    val list= mutableListOf<TvShowPoster>()
    this.forEach { list.add(it.toPresentationTvShowPoster()) }
    return list
}