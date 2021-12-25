package com.codeinglogs.remote.model.moviedetail.videos

import com.codeinglogs.data.model.moviedetail.videos.MovieVideosResponse as DataMovieVideosResponse
import com.codeinglogs.data.model.moviedetail.videos.MovieVideo as DataMovieVideo

data class MovieVideosResponse(
    val id: Int?,
    val results: List<MovieVideo>?
)

fun MovieVideosResponse.toDataMovieVideosResponse()=DataMovieVideosResponse(
    id=id?:0,
    results=results?.toDataMovieVideo()?: listOf()
)

fun List<MovieVideo>.toDataMovieVideo():List<DataMovieVideo>{
    val list= mutableListOf<DataMovieVideo>()
    this.forEach { list.add(it.toDataMovieVideo()) }
    return list
}