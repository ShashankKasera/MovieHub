package com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasons

data class TvShowSeasonsResponse(
    val _id: String,
    val air_date: String,
    val episodes: List<TvShowEpisode>,
    val id: Int,
    val name: String,
    val overview: String,
    val poster_path: String,
    val season_number: Int
)