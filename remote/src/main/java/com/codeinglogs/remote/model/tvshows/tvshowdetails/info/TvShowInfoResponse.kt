package com.codeinglogs.remote.model.tvshows.tvshowdetails.info

import com.codeinglogs.data.model.tvshow.tvshowdetails.info.TvShowGenre as DataTvShowGenre
import com.codeinglogs.data.model.tvshow.tvshowdetails.info.TvShowProductionCompany as DataTvShowProductionCompany
import com.codeinglogs.data.model.tvshow.tvshowdetails.info.TvShowSeason as DataTvShowSeason
import com.codeinglogs.data.model.tvshow.tvshowdetails.info.TvShowInfoResponse as DataTvShowInfoResponse

data class TvShowInfoResponse(
    val backdrop_path: String?,
    val episode_run_time: List<Int>?,
    val first_air_date: String?,
    val genres: List<TvShowGenre>?,
    val homepage: String?,
    val id: Int?,
    val in_production: Boolean?,
    val languages: List<String>?,
    val last_air_date: String?,
    val name: String?,
    val number_of_episodes: Int?,
    val number_of_seasons: Int?,
    val origin_country: List<String>?,
    val original_language: String?,
    val original_name: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val production_companies: List<TvShowProductionCompany>?,
    val seasons: List<TvShowSeason>?,
    val status: String?,
    val tagline: String?,
    val type: String?,
    val vote_average: Double?,
    val vote_count: Int
)

fun TvShowInfoResponse.toDataTvShowInfoResponse()=DataTvShowInfoResponse(

    backdrop_path =backdrop_path?:"",
    first_air_date =first_air_date?:"",
    genres=genres?.toDataTvShowGenre()?: listOf(),
    id=id?:0,
    name =name?:"",
    number_of_episodes=number_of_episodes?:0,
    number_of_seasons=number_of_seasons?:0,
    original_language =original_language?:"",
    original_name =original_name?:"",
    overview =overview?:"",
    poster_path =poster_path?:"",
    production_companies=production_companies?.toDataTvShowProductionCompany()?: listOf(),
    seasons=seasons?.toDataTvShowSeason()?: listOf(),
    status =status?:"",
    tagline =tagline?:"",
    type =type?:"",
    vote_average=vote_average?:0.0,
)

fun List<TvShowGenre>.toDataTvShowGenre():List<DataTvShowGenre>{
    val list= mutableListOf<DataTvShowGenre>()
    this.forEach { list.add(it.toDataTvShowGenre()) }
    return list
}

fun List<TvShowProductionCompany>.toDataTvShowProductionCompany():List<DataTvShowProductionCompany>{
    val list= mutableListOf<DataTvShowProductionCompany>()
    this.forEach { list.add(it.toDataTvShowProductionCompany()) }
    return list
}
fun List<TvShowSeason>.toDataTvShowSeason():List<DataTvShowSeason>{
    val list= mutableListOf<DataTvShowSeason>()
    this.forEach { list.add(it.toDataTvShowSeason()) }
    return list
}