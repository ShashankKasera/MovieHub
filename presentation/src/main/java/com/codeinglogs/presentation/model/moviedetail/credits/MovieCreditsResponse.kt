package com.codeinglogs.presentation.model.moviedetail.credits

import com.codeinglogs.domain.model.moviedetail.credits.MovieCreditsResponse as DomainMovieCreditsResponse
import com.codeinglogs.domain.model.moviedetail.credits.Cast as DomainCast
import com.codeinglogs.domain.model.moviedetail.credits.Crew as DomainCrew

data class MovieCreditsResponse(
    val cast: List<Cast>?,
    val crew: List<Crew>?,
    val id: Int?
)

fun DomainMovieCreditsResponse.toPresentationMovieCreditsResponse()=
    MovieCreditsResponse(
        cast = cast.toDomainCast(),
        crew = crew.toDomainCrew(),
        id = id ?: 0
    )

fun List<DomainCast>.toDomainCast():List<Cast>{
    val list= mutableListOf<Cast>()
    this.forEach { list.add(it.toPresentationCast()) }
    return list
}
fun List<DomainCrew>.toDomainCrew():List<Crew>{
    val list= mutableListOf<Crew>()
    this.forEach { list.add(it.toPresentationCrew()) }
    return list
}

