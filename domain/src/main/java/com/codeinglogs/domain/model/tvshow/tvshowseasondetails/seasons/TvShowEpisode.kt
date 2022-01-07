package com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasons

data class TvShowEpisode(
    val air_date: String,
    val crew: List<TvShowCrew>,
    val episode_number: Int,
    val id: Int,
    val name: String,
    val overview: String,
    val season_number: Int,
    val still_path: String,
    val vote_average: Double,
)