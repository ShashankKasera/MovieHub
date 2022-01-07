package com.codeinglogs.presentation.model.tvshow.tvshowseasondetails.seasoncredits

import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasoncredits.TvShowSeasonsCast as DomainTvShowSeasonsCast

data class TvShowSeasonsCast(
    val character: String,
    val id: Int,
    val known_for_department: String,
    val name: String,
    val profile_path: String
)

fun DomainTvShowSeasonsCast.toPresentationTvShowSeasonsCast()= TvShowSeasonsCast(
    character =character,
    id =id,
    known_for_department =known_for_department,
    name =name,
    profile_path =profile_path
)