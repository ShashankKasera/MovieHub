package com.codeinglogs.presentation.model.moviedetail.videos

import com.codeinglogs.domain.model.moviedetail.videos.MovieVideosResponse as DomainMovieVideosResponse
import com.codeinglogs.domain.model.moviedetail.videos.MovieVideo as DomainMovieVideo
data class MovieVideosResponse(
    val id: Int,
    val results: List<MovieVideo>
)

fun DomainMovieVideosResponse.toPresentationMovieVideosResponse()= MovieVideosResponse(
        id = id ?: 0,
        results = results.toPresentationMovieVideo()
    )

fun List<DomainMovieVideo>.toPresentationMovieVideo():List<MovieVideo>{
    val list= mutableListOf<MovieVideo>()
    this.forEach { list.add(it.toPresentationMovieVideo()) }
    return list
}