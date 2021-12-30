package com.codeinglogs.remote.model.movies.moviedetail.credits


import com.codeinglogs.data.model.movies.moviedetail.credits.MovieCrew as DataMovieCrew
data class MovieCrew(
    val adult: Boolean?,
    val credit_id: String?,
    val department: String?,
    val gender: Int?,
    val id: Int?,
    val job: String?,
    val known_for_department: String?,
    val name: String?,
    val original_name: String?,
    val popularity: Double?,
    val profile_path: String?
)

fun MovieCrew.toDataMovieCrew()=DataMovieCrew(
    credit_id=credit_id?:"",
    department=department?:"",
    id=id?:0,
    known_for_department=known_for_department?:"",
    name=name?:"",
    original_name=original_name?:"",
    profile_path=profile_path?:""
)