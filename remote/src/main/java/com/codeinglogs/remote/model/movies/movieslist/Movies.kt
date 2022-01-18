package com.codeinglogs.remote.model.movies.movieslist

import com.codeinglogs.data.model.movies.movieslist.Movies as DataMovies

data class Movies(
    val id: Long?,
    val original_language: String?,
    val original_name: String?,
    val original_title: String?,
    val poster_path: String?,
    val title: String?,
    val release_date: String?,
    val vote_average: Double?,

)

fun Movies.toDataMovies() = DataMovies(
    id = id?:0L,
    title = original_name?:original_title?:"",
    poster_path = poster_path?:"",
    vote_average=vote_average?:0.0,
    release_date=release_date?:""
)

