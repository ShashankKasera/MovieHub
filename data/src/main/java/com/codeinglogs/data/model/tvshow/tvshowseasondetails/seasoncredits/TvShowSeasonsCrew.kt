package com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasoncredits

import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasoncredits.TvShowSeasonsCrew as DomainTvShowSeasonsCrew

data class TvShowSeasonsCrew    (

    val id: Int,
    val known_for_department: String,
    val name: String,
    val profile_path: String
)

fun TvShowSeasonsCrew.toDomainTvShowSeasonsCrew()= DomainTvShowSeasonsCrew(
    id =id,
    known_for_department =known_for_department,
    name =name,
    profile_path =profile_path
)