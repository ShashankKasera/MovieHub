package com.codeinglogs.remote.model.movies.moviedetail.videos

import com.codeinglogs.data.model.movies.moviedetail.videos.MovieVideo as DataMovieVideo
data class MovieVideo(
    val id: String?,
    val iso_3166_1: String?,
    val iso_639_1: String?,
    val key: String?,
    val name: String?,
    val official: Boolean?,
    val published_at: String?,
    val site: String?,
    val size: Int?,
    val type: String?
)

fun MovieVideo.toDataMovieVideo()=DataMovieVideo(
    id =id?:"",
    key =key?:"",
    name =name?:"",
    published_at =published_at?:"",
    site =site?:"",
    type =type?:""
)