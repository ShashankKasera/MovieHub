package com.codeinglogs.data.model.tvshow.tvshowdetails.info

import com.codeinglogs.domain.model.tvshow.tvshowdetails.info.TvShowGenre as DomainTvShowGenre

data class TvShowGenre(
    val id: Int,
    val name: String
)

fun TvShowGenre.toDomainTvShowGenre()= DomainTvShowGenre(
    id=id,
    name=name
)