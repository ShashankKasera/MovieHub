package com.codeinglogs.data.model.tvshow.tvshowdetails.credits

import com.codeinglogs.domain.model.tvshow.tvshowdetails.credits.TvShowCast as DomainTvShowCast

data class TvShowCast(

    val id: Int,
    val known_for_department: String,
    val name: String,
    val profile_path: String
)

fun TvShowCast.toDomainTvShowCast()= DomainTvShowCast(

    id=id,
    known_for_department =known_for_department,
    name =name,
    profile_path =profile_path
)