package com.codeinglogs.remote.model.tvshows.tvshowdetails.image

import com.codeinglogs.data.model.tvshow.tvshowdetails.image.TvShowImageResponse as DataTvShowImageResponse
import com.codeinglogs.data.model.tvshow.tvshowdetails.image.TvShowBackdrop as DataTvShowBackdrop
import com.codeinglogs.data.model.tvshow.tvshowdetails.image.TvShowPoster as DataTvShowPoster

data class TvShowImageResponse(
    val backdrops: List<TvShowBackdrop>?,
    val id: Int?,
    val logos: List<TvShowLogo>?,
    val posters: List<TvShowPoster>?
)

fun TvShowImageResponse.toDataTvShowImageResponse()=DataTvShowImageResponse(
    id=id?:0,
    backdrops = backdrops?.toDataTvShowBackdrop() ?: listOf(),
    posters = posters?.toDataTvShowPoster() ?:listOf()
)

fun List<TvShowBackdrop>.toDataTvShowBackdrop():List<DataTvShowBackdrop>{
    val list= mutableListOf<DataTvShowBackdrop>()
    this.forEach { list.add(it.toDataTvShowBackdrop()) }
    return list
}

fun List<TvShowPoster>.toDataTvShowPoster():List<DataTvShowPoster>{
    val list= mutableListOf<DataTvShowPoster>()
    this.forEach { list.add(it.toDataTvShowPoster()) }
    return list
}