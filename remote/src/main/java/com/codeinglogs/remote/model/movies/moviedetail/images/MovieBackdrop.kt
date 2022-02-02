package com.codeinglogs.remote.model.movies.moviedetail.images

import com.codeinglogs.data.model.movies.moviedetail.images.MovieBackdrop as DataMovieBackdrop
data class MovieBackdrop(

    val aspect_ratio: Double?,
    val file_path: String?,
    val height: Int?,
    val iso_639_1: Any?,
    val vote_average: Double?,
    val vote_count: Int?,
    val width: Int?
)

fun MovieBackdrop.toDataMovieBackdrop()=DataMovieBackdrop(

    file_path=file_path?:"",
    vote_count=vote_count?:0
)