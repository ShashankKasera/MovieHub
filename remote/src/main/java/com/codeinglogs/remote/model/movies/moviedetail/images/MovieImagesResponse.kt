package com.codeinglogs.remote.model.movies.moviedetail.images

import com.codeinglogs.data.model.movies.moviedetail.images.MovieIMagesResponse as DataMovieIMagesResponse
import com.codeinglogs.data.model.movies.moviedetail.images.MovieBackdrop as DataMovieBackdrop
import com.codeinglogs.data.model.movies.moviedetail.images.MoviePoster as DataMoviePoster

data class MovieImagesResponse(
    val backdrops: List<MovieBackdrop>?,
    val id: Int?,
    val logos: List<MovieLogo>?,
    val posters: List<MoviePoster>?
)

fun MovieImagesResponse.toDataMovieIMagesResponse()=DataMovieIMagesResponse(
    backdrops=backdrops?.toDataMovieBackdrop()?: listOf(),
    id=id?:0,
    posters=posters?.toDataMoviePoster()?: listOf()
)

fun List<MovieBackdrop>.toDataMovieBackdrop():List<DataMovieBackdrop>{
    val list= mutableListOf<DataMovieBackdrop>()
    this.forEach { list.add(it.toDataMovieBackdrop()) }
    return list
}

fun List<MoviePoster>.toDataMoviePoster():List<DataMoviePoster>{
    val list= mutableListOf<DataMoviePoster>()
    this.forEach { list.add(it.toDataMoviePoster()) }
    return list
}