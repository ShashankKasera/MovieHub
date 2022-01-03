package com.codeinglogs.remote.model.tvshows.tvshowdetails.info
import com.codeinglogs.data.model.tvshow.tvshowdetails.info.TvShowGenre as DataTvShowGenre

data class TvShowGenre(
    val id: Int?,
    val name: String?
)

fun TvShowGenre.toDataTvShowGenre()=DataTvShowGenre(
    id=id?:0,
    name=name?:""
)