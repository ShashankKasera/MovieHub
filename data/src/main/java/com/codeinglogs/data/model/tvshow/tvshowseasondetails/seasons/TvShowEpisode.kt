package com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasons

import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasons.TvShowEpisode as DomainTvShowEpisode
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasons.TvShowCrew as DomainTvShowCrew

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

fun TvShowEpisode.toDomainTvShowEpisode()= DomainTvShowEpisode(
    air_date =air_date,
    crew=crew.toDomainTvShowCrew(),
    episode_number =episode_number,
    id =id,
    name =name,
    overview =overview,
    season_number =season_number,
    still_path =still_path,
    vote_average =vote_average,
)

fun List<TvShowCrew>.toDomainTvShowCrew():List<DomainTvShowCrew>{
    val list= mutableListOf<DomainTvShowCrew>()
    this.forEach { list.add(it.toDomainTvShowCrew()) }
    return list
}