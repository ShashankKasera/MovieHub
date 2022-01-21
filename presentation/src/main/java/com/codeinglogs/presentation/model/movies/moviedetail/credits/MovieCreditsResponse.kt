package com.codeinglogs.presentation.model.movies.moviedetail.credits

import com.codeinglogs.presentation.model.person.personlist.Person
import com.codeinglogs.presentation.model.person.personlist.toPresentationPerson
import com.codeinglogs.domain.model.movies.moviedetail.credits.MovieCreditsResponse as DomainMovieCreditsResponse

data class MovieCreditsResponse(
    val cast: List<Person>,
    val crew: List<Person>,
    val id: Int?
)

fun DomainMovieCreditsResponse.toPresentationMovieCreditsResponse()=
    MovieCreditsResponse(
        cast = cast.toPresentationPerson(),
        crew = crew.toPresentationPerson(),
        id = id
    )

