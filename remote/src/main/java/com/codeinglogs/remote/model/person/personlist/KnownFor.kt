package com.codeinglogs.remote.model.person.personlist

import com.codeinglogs.data.model.person.personlist.KnownFor as DataKnownFor
data class KnownFor(
    val adult: Boolean?,
    val backdrop_path: String?,
    val first_air_date: String?,
    val genre_ids: List<Double>?,
    val id: Double?,
    val media_type: String?,
    val name: String?,
    val origin_country: List<String>,
    val original_language: String?,
    val original_name: String?,
    val original_title: String?,
    val overview: String?,
    val poster_path: String?,
    val release_date: String?,
    val title: String?,
    val video: Boolean?,
    val vote_average: Double?,
    val vote_count: Double?
)
fun KnownFor.toDataKnownFor() = DataKnownFor(
     adult=adult?:false,
     backdrop_path=backdrop_path?:"",
     first_air_date=first_air_date?:"",
     genre_ids=genre_ids?: listOf(),
     id=id?:0.0,
     media_type=media_type?:"",
     name=name?:"",
     origin_country=origin_country?: listOf(),
     original_language=original_language?:"",
     original_name= original_name?:"",
     original_title= original_title?:"",
     overview= overview?:"",
     poster_path=poster_path ?:"",
     release_date= release_date?:"",
     title= title?:"",
     video= video?:false,
     vote_average= vote_average?:0.0,
    vote_count = vote_count?:0.0
)


