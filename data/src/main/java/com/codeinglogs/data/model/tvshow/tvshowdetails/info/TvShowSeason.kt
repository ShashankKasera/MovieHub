package com.codeinglogs.data.model.tvshow.tvshowdetails.info

import com.codeinglogs.domain.model.tvshow.tvshowdetails.info.TvShowSeason as DomainTvShowSeason

data class TvShowSeason(
    val air_date: String,
    val episode_count: Int,
    val id: Int,
    val name: String,
    val overview: String,
    val poster_path: String,
    val season_number: Int
)

fun TvShowSeason.toDomainTvShowSeason()= DomainTvShowSeason(
    id=id,
    name=name,
    overview = overview,
    season_number = season_number,
    episode_count = episode_count,
    air_date=air_date,
    poster_path=poster_path
)