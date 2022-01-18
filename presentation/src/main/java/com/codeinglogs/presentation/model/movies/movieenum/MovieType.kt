package com.codeinglogs.presentation.model.movies.movieenum
import com.codeinglogs.domain.model.movies.movieenum.MovieType as DomainMovieType

enum class MovieType {
    TRENDING,POPULAR,TOP_RATED
}

fun MovieType.toDomainMovieType()= when(this){
    MovieType.TRENDING -> DomainMovieType.TRENDING
    MovieType.POPULAR -> DomainMovieType.POPULAR
    MovieType.TOP_RATED -> DomainMovieType.TOP_RATED
}