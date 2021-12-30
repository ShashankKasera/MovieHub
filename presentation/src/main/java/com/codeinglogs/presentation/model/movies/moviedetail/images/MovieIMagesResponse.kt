package com.codeinglogs.presentation.model.movies.moviedetail.images

import com.codeinglogs.domain.model.movies.moviedetail.images.MovieIMagesResponse as DomainMovieIMagesResponse
import com.codeinglogs.domain.model.movies.moviedetail.images.MovieBackdrop as DomainMovieBackdrop
import com.codeinglogs.domain.model.movies.moviedetail.images.MoviePoster as DomainMoviePoster

data class MovieIMagesResponse(
    val backdrops: List<MovieBackdrop>,
    val id: Int,
    val posters: List<MoviePoster>
)

fun DomainMovieIMagesResponse.toPresentationMovieIMagesResponse()= MovieIMagesResponse(
    backdrops=backdrops.toPresentationMovieBackdrop(),
    id=id,
    posters=posters.toPresentationMoviePoster()
)

fun List<DomainMovieBackdrop>.toPresentationMovieBackdrop():List<MovieBackdrop>{
    val list= mutableListOf<MovieBackdrop>()
    this.forEach { list.add(it.toPresentationMovieBackdrop()) }
    return list
}

fun List<DomainMoviePoster>.toPresentationMoviePoster():List<MoviePoster>{
    val list= mutableListOf<MoviePoster>()
    this.forEach { list.add(it.toPresentationMoviePoster()) }
    return list
}