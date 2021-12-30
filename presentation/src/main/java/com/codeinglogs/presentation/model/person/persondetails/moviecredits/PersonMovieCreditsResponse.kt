package com.codeinglogs.presentation.model.person.persondetails.moviecredits

import com.codeinglogs.domain.model.person.persondetails.moviecredits.PersonMovieCreditsResponse as DomainPersonMovieCreditsResponse
import com.codeinglogs.domain.model.person.persondetails.moviecredits.PersonMovieCastAndCrew as DomainPersonMovieCastAndCrew

data class PersonMovieCreditsResponse(
    val credit:List<PersonMovieCastAndCrew>,
    val id: Int
)

fun DomainPersonMovieCreditsResponse.toPresentationPersonMovieCreditsResponse()=PersonMovieCreditsResponse(
    credit=credit.toPresentationPersonMovieCastAndCrew(),
    id=id
)

fun List<DomainPersonMovieCastAndCrew>.toPresentationPersonMovieCastAndCrew(): List<PersonMovieCastAndCrew> {
    val list = mutableListOf<PersonMovieCastAndCrew>()
    this.forEach { list.add(it.toPresentationPersonMovieCastAndCrew()) }
    return list
}



