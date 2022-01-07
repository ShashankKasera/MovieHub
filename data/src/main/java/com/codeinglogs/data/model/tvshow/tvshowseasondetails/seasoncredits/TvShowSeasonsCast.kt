package com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasoncredits

import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasoncredits.TvShowSeasonsCast as DomainTvShowSeasonsCast

data class TvShowSeasonsCast(
    val character: String,
    val id: Int,
    val known_for_department: String,
    val name: String,
    val profile_path: String
)

fun TvShowSeasonsCast.toDomainTvShowSeasonsCast()= DomainTvShowSeasonsCast(
    character =character,
    id =id,
    known_for_department =known_for_department,
    name =name,
    profile_path =profile_path
)