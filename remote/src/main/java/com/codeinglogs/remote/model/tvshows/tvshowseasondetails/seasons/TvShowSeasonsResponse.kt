package com.codeinglogs.remote.model.tvshows.tvshowseasondetails.seasons
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasons.TvShowSeasonsResponse as DataTvShowSeasonsResponse
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasons.TvShowEpisode as DataTvShowEpisode

data class TvShowSeasonsResponse(
    val _id: String?,
    val air_date: String?,
    val episodes: List<TvShowEpisode>?,
    val id: Int?,
    val name: String?,
    val overview: String?,
    val poster_path: String?,
    val season_number: Int
)

fun TvShowSeasonsResponse.toDataTvShowSeasonsResponse()=DataTvShowSeasonsResponse(
    _id =_id?:"",
    air_date =air_date?:"",
    episodes=episodes?.toDataTvShowEpisode()?: listOf(),
    id =id?:0,
    name =name?:"",
    overview =overview?:"",
    poster_path =poster_path?:"",
    season_number =season_number?:0
)
fun List<TvShowEpisode>.toDataTvShowEpisode():List<DataTvShowEpisode>{
    val list= mutableListOf<DataTvShowEpisode>()
    this.forEach { list.add(it.toDataTvShowEpisode()) }
    return list
}