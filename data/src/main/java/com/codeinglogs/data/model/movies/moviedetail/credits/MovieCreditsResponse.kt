package com.codeinglogs.data.model.movies.moviedetail.credits

import com.codeinglogs.domain.model.movies.moviedetail.credits.MovieCreditsResponse as DomainMovieCreditsResponse
import com.codeinglogs.domain.model.movies.moviedetail.credits.MovieCast as DomainMovieCast
import com.codeinglogs.domain.model.movies.moviedetail.credits.MovieCrew as DomainMovieCrew

data class MovieCreditsResponse(
    val cast: List<MovieCast>,
    val crew: List<MovieCrew>,
    val id: Int
)

fun MovieCreditsResponse.toDomainMovieCreditsResponse()= DomainMovieCreditsResponse(
    cast=cast.toDomainMovieCast(),
    crew=crew.toDomainCrew(),
    id=id?:0
)

fun List<MovieCast>.toDomainMovieCast():List<DomainMovieCast>{
    val list= mutableListOf<DomainMovieCast>()
    this.forEach { list.add(it.toDomainMovieCast()) }
    return list
}
fun List<MovieCrew>.toDomainCrew():List<DomainMovieCrew>{
    val list= mutableListOf<DomainMovieCrew>()
    this.forEach { list.add(it.toDomainMovieCrew()) }
    return list
}

