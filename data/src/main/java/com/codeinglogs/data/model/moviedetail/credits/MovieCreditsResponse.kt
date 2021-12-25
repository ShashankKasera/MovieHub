package com.codeinglogs.data.model.moviedetail.credits

import com.codeinglogs.domain.model.moviedetail.credits.MovieCreditsResponse as DomainMovieCreditsResponse
import com.codeinglogs.domain.model.moviedetail.credits.Cast as DomainCast
import com.codeinglogs.domain.model.moviedetail.credits.Crew as DomainCrew

data class MovieCreditsResponse(
    val cast: List<Cast>,
    val crew: List<Crew>,
    val id: Int
)

fun MovieCreditsResponse.toDomainMovieCreditsResponse()= DomainMovieCreditsResponse(
    cast=cast.toDomainCast(),
    crew=crew.toDomainCrew(),
    id=id?:0
)

fun List<Cast>.toDomainCast():List<DomainCast>{
    val list= mutableListOf<DomainCast>()
    this.forEach { list.add(it.toDomainCast()) }
    return list
}
fun List<Crew>.toDomainCrew():List<DomainCrew>{
    val list= mutableListOf<DomainCrew>()
    this.forEach { list.add(it.toDomainCrew()) }
    return list
}

