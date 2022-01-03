package com.codeinglogs.data.model.tvshow.tvshowdetails.image

import com.codeinglogs.domain.model.tvshow.tvshowdetails.image.TvShowBackdrop as DomainTvShowBackdrop
import com.codeinglogs.domain.model.tvshow.tvshowdetails.image.TvShowPoster as DomainTvShowPoster
import com.codeinglogs.domain.model.tvshow.tvshowdetails.image.TvShowImageResponse as DomainTvShowImageResponse

data class TvShowImageResponse(
    val backdrops: List<TvShowBackdrop>,
    val id: Int,
    val posters: List<TvShowPoster>
)

fun  TvShowImageResponse.toDomainTvShowImageResponse()= DomainTvShowImageResponse(
    id=id,
    backdrops = backdrops.toDomainTvShowBackdrop(),
    posters = posters.toDomainTvShowPoster()
)

fun List<TvShowBackdrop>.toDomainTvShowBackdrop():List<DomainTvShowBackdrop>{
    val list= mutableListOf<DomainTvShowBackdrop>()
    this.forEach { list.add(it.toDomainTvShowBackdrop()) }
    return list
}

fun List<TvShowPoster>.toDomainTvShowPoster():List<DomainTvShowPoster>{
    val list= mutableListOf<DomainTvShowPoster>()
    this.forEach { list.add(it.toDomainTvShowPoster()) }
    return list
}