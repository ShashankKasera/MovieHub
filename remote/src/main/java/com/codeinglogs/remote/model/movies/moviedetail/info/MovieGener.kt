package com.codeinglogs.remote.model.movies.moviedetail.info

import com.codeinglogs.data.model.movies.moviedetail.info.MovieGener as DataMovieGener
data class MovieGener(
    val id: Int?,
    val name: String?
)

fun MovieGener.toDataMovieGener()=DataMovieGener(
    id = id?:0,
    name=name?:""
)