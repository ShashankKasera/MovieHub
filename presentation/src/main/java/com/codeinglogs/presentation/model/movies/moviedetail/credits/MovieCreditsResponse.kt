package com.codeinglogs.presentation.model.movies.moviedetail.credits

import com.codeinglogs.domain.model.movies.moviedetail.credits.MovieCreditsResponse as DomainMovieCreditsResponse
import com.codeinglogs.domain.model.movies.moviedetail.credits.MovieCast as DomainMovieCast
import com.codeinglogs.domain.model.movies.moviedetail.credits.MovieCrew as DomainMovieCrew

data class MovieCreditsResponse(
    val cast: List<MovieCast>,
    val crew: List<MovieCrew>,
    val id: Int?
)

fun DomainMovieCreditsResponse.toPresentationMovieCreditsResponse()=
    MovieCreditsResponse(
        cast = cast.toDomainMovieCast(),
        crew = crew.toDomainMovieCrew(),
        id = id
    )

fun List<DomainMovieCast>.toDomainMovieCast():List<MovieCast>{
    val list= mutableListOf<MovieCast>()
    this.forEach { list.add(it.toPresentationMovieCast()) }
    return list
}
fun List<DomainMovieCrew>.toDomainMovieCrew():List<MovieCrew>{
    val list= mutableListOf<MovieCrew>()
    this.forEach { list.add(it.toPresentationMovieCrew()) }
    return list
}

