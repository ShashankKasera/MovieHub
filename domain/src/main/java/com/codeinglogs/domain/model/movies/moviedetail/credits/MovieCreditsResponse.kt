package com.codeinglogs.domain.model.movies.moviedetail.credits

import com.codeinglogs.domain.model.person.personlist.Person

data class MovieCreditsResponse(
    val cast: List<Person>,
    val crew: List<Person>,
    val id: Int
)