package com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasons

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


fun TvShowSeasonsResponse.toDomainTvShowSeasonsResponse()=DomainTvShowSeasonsResponse(
        _id = _id,
        air_date = air_date,
        episodes = episodes.toDomainTvShowEpisode() ,
        id = id,
        name = name,
        overview = overview,
        poster_path = poster_path,
        season_number = season_number
    )
fun List<TvShowEpisode>.toDomainTvShowEpisode():List<DomainTvShowEpisode>{
    val list= mutableListOf<DomainTvShowEpisode>()
    this.forEach { list.add(it.toDomainTvShowEpisode()) }
    return list
}