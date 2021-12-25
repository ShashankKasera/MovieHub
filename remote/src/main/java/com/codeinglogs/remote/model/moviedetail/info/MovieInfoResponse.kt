package com.codeinglogs.remote.model.moviedetail.info

import com.codeinglogs.data.model.moviedetail.info.MovieInfoResponse as DataMovieInfoResponse
import com.codeinglogs.data.model.moviedetail.info.Gener as DataGener

data class MovieInfoResponse(
    val adult: Boolean?,
    val backdrop_path:String?,
    val belongs_to_collection: String?,
    val budget:Int?,
    val genres: List<Gener>?,
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

    backdrop_path=backdrop_path?:"",
    belongs_to_collection=belongs_to_collection?:"",
    budget=budget?:0,
    genres=genres?.toDataGener()?: listOf(),
    homepage=homepage?:"",
    id=id?:0,
    imdb_id=imdb_id?:"",
    original_language=original_language?:"",
    original_title=original_title?:"",
    overview=overview?:"",
    popularity=popularity?:0.0,
    poster_path=poster_path?:"",
    release_date=release_date?:"",
    revenue=revenue?:0,
    runtime=runtime?:0,
    status=status?:"",
    tagline=tagline?:"",
    title=title?:"",
    video=video?:false,
    vote_average=vote_average?:0.0,
    vote_count=vote_count?:0
)

fun List<Gener>.toDataGener():List<DataGener> {
    val list= mutableListOf<DataGener>()
    this.forEach { list.add(it.toDataGener()) }
    return list
}