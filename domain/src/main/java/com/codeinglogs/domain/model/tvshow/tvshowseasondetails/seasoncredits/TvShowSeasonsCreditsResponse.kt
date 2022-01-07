package com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasoncredits

data class TvShowSeasonsCreditsResponse(
    val cast: List<TvShowSeasonsCast>,
    val crew: List<TvShowSeasonsCrew>,
    val id: Int
)