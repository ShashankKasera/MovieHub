package com.codeinglogs.remote.model.movies.moviedetail.credits

import com.codeinglogs.remote.model.person.personlist.Person
import com.codeinglogs.remote.model.person.personlist.toDataPerson
import com.codeinglogs.data.model.movies.moviedetail.credits.MovieCreditsResponse as DataMovieCreditsResponse
import com.codeinglogs.data.model.person.personlist.Person as DataPerson

data class MovieCreditsResponse(
    val cast: List<Person>?,
    val crew: List<Person>?,
    val id: Int?
)

fun MovieCreditsResponse.toDataMovieCreditsResponse()=DataMovieCreditsResponse(
    cast=cast?.toDataPerson()?: listOf(),
    crew=crew?.toDataPerson()?: listOf(),
    id=id?:0
)