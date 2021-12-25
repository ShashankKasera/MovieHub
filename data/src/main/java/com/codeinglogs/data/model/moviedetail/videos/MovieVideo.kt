package com.codeinglogs.data.model.moviedetail.videos


import com.codeinglogs.domain.model.moviedetail.videos.MovieVideo as DomainMovieVideo
data class MovieVideo(
    val id: String,
    val key: String,
    val name: String,
    val published_at: String,
    val site: String,
    val type: String
)

fun MovieVideo.toDomainMovieVideo()= DomainMovieVideo(
    id =id,
    key =key,
    name =name,
    published_at =published_at,
    site =site,
    type =type
)