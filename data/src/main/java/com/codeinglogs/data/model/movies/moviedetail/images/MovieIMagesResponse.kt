package com.codeinglogs.data.model.movies.moviedetail.images

import com.codeinglogs.domain.model.movies.moviedetail.images.MovieIMagesResponse as DomainMovieIMagesResponse
import com.codeinglogs.domain.model.movies.moviedetail.images.MovieBackdrop as DomainMovieBackdrop
import com.codeinglogs.domain.model.movies.moviedetail.images.MoviePoster as DomainMoviePoster


data class MovieIMagesResponse(
    val id: Int,
    val backdrops: List<MovieBackdrop>,
    val posters: List<MoviePoster>
)

fun MovieIMagesResponse.toDomainMovieIMagesResponse()= DomainMovieIMagesResponse(
    backdrops=backdrops.toDomainMovieBackdrop(),
    id=id,
    posters=posters.toDomainMoviePoster()
)

fun List<MovieBackdrop>.toDomainMovieBackdrop():List<DomainMovieBackdrop>{
    val list= mutableListOf<DomainMovieBackdrop>()
    this.forEach { list.add(it.toDomainMovieBackdrop()) }
    return list
}

fun List<MoviePoster>.toDomainMoviePoster():List<DomainMoviePoster>{
    val list= mutableListOf<DomainMoviePoster>()
    this.forEach { list.add(it.toDomainMoviePoster()) }
    return list
}