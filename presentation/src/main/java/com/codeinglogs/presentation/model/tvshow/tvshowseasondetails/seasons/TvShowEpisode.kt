package com.codeinglogs.presentation.model.tvshow.tvshowseasondetails.seasons
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

fun DomainTvShowEpisode.toPresentationTvShowEpisode()= TvShowEpisode(
    air_date =air_date,
    crew=crew.toPresentationTvShowCrew(),
    episode_number =episode_number,
    id =id,
    name =name,
    overview =overview,
    season_number =season_number,
    still_path =still_path,
    vote_average =vote_average,
)

fun List<DomainTvShowCrew>.toPresentationTvShowCrew():List<TvShowCrew>{
    val list= mutableListOf<TvShowCrew>()
    this.forEach { list.add(it.toPresentationTvShowCrew()) }
    return list
}