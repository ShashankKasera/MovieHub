package com.codeinglogs.remote.model.tvshows.tvshowdetails.info
import com.codeinglogs.data.model.tvshow.tvshowdetails.info.TvShowSeason as DataTvShowSeason

data class TvShowSeason(
    val air_date: String?,
    val episode_count: Int?,
    val id: Int?,
    val name: String?,
    val overview: String?,
    val poster_path: String?,
    val season_number: Int?
)
fun TvShowSeason.toDataTvShowSeason()=DataTvShowSeason(
    id=id?:0,
    name=name?:"",
    overview = overview?:"",
    season_number = season_number?:0,
    episode_count = episode_count?:0,
    air_date=air_date?:"",
    poster_path=poster_path?:""
)