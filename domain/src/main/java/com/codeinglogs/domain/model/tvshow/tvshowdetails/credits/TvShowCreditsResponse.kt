package com.codeinglogs.domain.model.tvshow.tvshowdetails.credits

data class TvShowCreditsResponse(
    val cast: List<TvShowCast>,
    val crew: List<TvShowCrew>,
    val id: Int
)