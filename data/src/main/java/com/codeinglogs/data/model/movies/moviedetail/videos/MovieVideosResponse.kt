package com.codeinglogs.data.model.movies.moviedetail.videos

import com.codeinglogs.domain.model.movies.moviedetail.videos.MovieVideosResponse as DomainMovieVideosResponse
import com.codeinglogs.domain.model.movies.moviedetail.videos.MovieVideo as DomainMovieVideo
data class MovieVideosResponse(
    val id: Int,
    val results: List<MovieVideo>
)

fun MovieVideosResponse.toDomainMovieVideosResponse()= DomainMovieVideosResponse(
    id=id?:0,
    results=results.toDomainMovieVideo()
)

fun List<MovieVideo>.toDomainMovieVideo():List<DomainMovieVideo>{
    val list= mutableListOf<DomainMovieVideo>()
    this.forEach { list.add(it.toDomainMovieVideo()) }
    return list
}