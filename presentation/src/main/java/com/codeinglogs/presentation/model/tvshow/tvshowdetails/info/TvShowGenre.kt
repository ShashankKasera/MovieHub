package com.codeinglogs.presentation.model.tvshow.tvshowdetails.info

import com.codeinglogs.domain.model.tvshow.tvshowdetails.info.TvShowGenre as DomainTvShowGenre

data class TvShowGenre(
    val id: Int,
    val name: String
)

fun DomainTvShowGenre.toPresentationTvShowGenre()= TvShowGenre(
    id=id,
    name=name
)