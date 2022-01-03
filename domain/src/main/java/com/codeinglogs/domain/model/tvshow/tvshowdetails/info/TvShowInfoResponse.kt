package com.codeinglogs.domain.model.tvshow.tvshowdetails.info



data class TvShowInfoResponse(
    val backdrop_path: String,
    val first_air_date: String,
    val genres: List<TvShowGenre>,
    val id: Int,
    val name: String,
    val number_of_episodes: Int,
    val number_of_seasons: Int,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val poster_path: String,
    val production_companies: List<TvShowProductionCompany>,
    val seasons: List<TvShowSeason>,
    val status: String,
    val tagline: String,
    val type: String,
    val vote_average: Double,
)