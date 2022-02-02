package com.codeinglogs.data.model.movies.moviedetail.credits

import com.codeinglogs.data.model.person.personlist.Person
import com.codeinglogs.data.model.person.personlist.toDomainPerson
import com.codeinglogs.domain.model.movies.moviedetail.credits.MovieCreditsResponse as DomainMovieCreditsResponse


data class MovieCreditsResponse(
    val id: Int,
    val cast: List<Person>,
    val crew: List<Person>,
)

fun MovieCreditsResponse.toDomainMovieCreditsResponse()= DomainMovieCreditsResponse(
    cast=cast.toDomainPerson(),
    crew=crew.toDomainPerson(),
    id=id?:0
)


