package com.codeinglogs.domain.model.person.persondetails.moviecredits

data class PersonMovieCreditsResponse(
    val credit:List<PersonMovieCastAndCrew>,
    val id: Int
)