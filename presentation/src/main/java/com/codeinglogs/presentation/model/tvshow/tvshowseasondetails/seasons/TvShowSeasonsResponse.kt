package com.codeinglogs.presentation.model.tvshow.tvshowseasondetails.seasons

import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasons.TvShowSeasonsResponse as DomainTvShowSeasonsResponse
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasons.TvShowEpisode as DomainTvShowEpisode


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

fun DomainTvShowSeasonsResponse.toPresentationTvShowSeasonsResponse()=TvShowSeasonsResponse(
    _id = _id,
    air_date = air_date,
    episodes = episodes.toPresentationTvShowEpisode() ,
    id = id,
    name = name,
    overview = overview,
    poster_path = poster_path,
    season_number = season_number
)
fun List<DomainTvShowEpisode>.toPresentationTvShowEpisode():List<TvShowEpisode>{
    val list= mutableListOf<TvShowEpisode>()
    this.forEach { list.add(it.toPresentationTvShowEpisode()) }
    return list
}