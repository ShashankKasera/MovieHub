package com.codeinglogs.presentation.model.tvshow.tvshowdetails.info

import com.codeinglogs.domain.model.tvshow.tvshowdetails.info.TvShowGenre as DomainTvShowGenre
import com.codeinglogs.domain.model.tvshow.tvshowdetails.info.TvShowProductionCompany as DomainTvShowProductionCompany
import com.codeinglogs.domain.model.tvshow.tvshowdetails.info.TvShowSeason as DomainTvShowSeason
import com.codeinglogs.domain.model.tvshow.tvshowdetails.info.TvShowInfoResponse as DomainTvShowInfoResponse


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

fun DomainTvShowInfoResponse.toPresentationTvShowInfoResponse()= TvShowInfoResponse(

    backdrop_path =backdrop_path,
    first_air_date =first_air_date,
    genres=genres.toPresentationTvShowGenre(),
    id=id,
    name =name,
    number_of_episodes=number_of_episodes,
    number_of_seasons=number_of_seasons,
    original_language =original_language,
    original_name =original_name,
    overview =overview,
    poster_path =poster_path,
    production_companies=production_companies.toPresentationTvShowProductionCompany(),
    seasons=seasons.toPresentationTvShowSeason(),
    status =status,
    tagline =tagline,
    type =type,
    vote_average=vote_average,
)

fun List<DomainTvShowGenre>.toPresentationTvShowGenre():List<TvShowGenre>{
    val list= mutableListOf<TvShowGenre>()
    this.forEach { list.add(it.toPresentationTvShowGenre()) }
    return list
}

fun List<DomainTvShowProductionCompany>.toPresentationTvShowProductionCompany():List<TvShowProductionCompany>{
    val list= mutableListOf<TvShowProductionCompany>()
    this.forEach { list.add(it.toPresentationTvShowProductionCompany()) }
    return list
}
fun List<DomainTvShowSeason>.toPresentationTvShowSeason():List<TvShowSeason>{
    val list= mutableListOf<TvShowSeason>()
    this.forEach { list.add(it.toPresentationTvShowSeason()) }
    return list
}