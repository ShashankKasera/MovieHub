package com.codeinglogs.remote.model.moviedetail.images

import com.codeinglogs.data.model.moviedetail.images.MoviePoster as DataMoviePoster

data class MoviePoster(
    val aspect_ratio: Double?,
    val file_path: String?,
    val height: Int?,
    val iso_639_1: String?,
    val vote_average: Double?,
    val vote_count: Int?,
    val width: Int?
)

fun MoviePoster.toDataMoviePoster()=DataMoviePoster(
    file_path = file_path?:"",
    vote_count = vote_count?:0
)