package com.codeinglogs.remote.model.movies.moviedetail.info

import com.codeinglogs.data.model.movies.moviedetail.info.MovieInfoResponse as DataMovieInfoResponse
import com.codeinglogs.data.model.movies.moviedetail.info.MovieGener as DataMovieGener
import com.codeinglogs.data.model.movies.moviedetail.info.MovieProductionCompanies as DataMovieProductionCompanies

data class MovieInfoResponse(
    val adult: Boolean?,
    val backdrop_path:String?,
    val budget:Int?,
    val production_companies: List<MovieProductionCompanies>?,
    val genres: List<MovieGener>?,
    val homepage: String?,
    val id: Int?,
    val imdb_id: String?,
    val original_language: String?,
    val original_title: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val release_date: String?,
    val revenue: Int?,
    val runtime: Int?,
    val status: String?,
    val tagline: String?,
    val title: String?,
    val video: Boolean?,
    val vote_average: Double?,
    val vote_count: Int?
)

fun MovieInfoResponse.toDataMovieInfoResponse()=DataMovieInfoResponse(

    production_companies=production_companies?.toDataMovieProductionCompanies()?: listOf(),
    backdrop_path=backdrop_path?:"",
    budget=budget?:0,
    genres=genres?.toDataMovieGener()?: listOf(),
    id=id?:0,
    original_language=original_language?:"",
    original_title=original_title?:"",
    overview=overview?:"",
    poster_path=poster_path?:"",
    release_date=release_date?:"",
    revenue=revenue?:0,
    runtime=runtime?:0,
    status=status?:"",
    title=title?:"",
    vote_average=vote_average?:0.0,

)

fun List<MovieGener>.toDataMovieGener():List<DataMovieGener> {
    val list= mutableListOf<DataMovieGener>()
    this.forEach { list.add(it.toDataMovieGener()) }
    return list
}

fun List<MovieProductionCompanies>.toDataMovieProductionCompanies():List<DataMovieProductionCompanies> {
    val list= mutableListOf<DataMovieProductionCompanies>()
    this.forEach { list.add(it.toDataMovieProductionCompanies()) }
    return list
}