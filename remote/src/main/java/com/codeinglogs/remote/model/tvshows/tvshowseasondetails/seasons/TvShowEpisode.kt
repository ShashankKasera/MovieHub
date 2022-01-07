package com.codeinglogs.remote.model.tvshows.tvshowseasondetails.seasons

import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasons.TvShowEpisode as DataTvShowEpisode
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasons.TvShowCrew as DataTvShowCrew

data class TvShowEpisode(
    val air_date: String?,
    val crew: List<TvShowCrew>?,
    val episode_number: Int?,
    val guest_stars: List<TvShowGuestStar>?,
    val id: Int?,
    val name: String?,
    val overview: String?,
    val production_code: String?,
    val season_number: Int?,
    val still_path: String?,
    val vote_average: Double?,
    val vote_count: Int
)

fun TvShowEpisode.toDataTvShowEpisode()=DataTvShowEpisode(
    air_date =air_date?:"",
    crew=crew?.toDataTvShowCrew()?: listOf(),
    episode_number =episode_number?:0,
    id =id?:0,
    name =name?:"",
    overview =overview?:"",
    season_number =season_number?:0,
    still_path =still_path?:"",
    vote_average =vote_average?:0.0,
)

fun List<TvShowCrew>.toDataTvShowCrew():List<DataTvShowCrew>{
    val list= mutableListOf<DataTvShowCrew>()
    this.forEach { list.add(it.toDataTvShowCrew()) }
    return list
}

