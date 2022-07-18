package com.codeinglogs.data.model.person.persondetails.moviecredits

import com.codeinglogs.domain.model.person.persondetails.moviecredits.PersonMovieCreditsResponse as DomainPersonMovieCreditsResponse
import com.codeinglogs.domain.model.person.persondetails.moviecredits.PersonMovieCastAndCrew as DomainPersonMovieCastAndCrew

data class PersonMovieCreditsResponse(

    val id: Int,
    val credit:List<PersonMovieCastAndCrew>,
)

fun PersonMovieCreditsResponse.toDomainPersonMovieCreditsResponse()=DomainPersonMovieCreditsResponse(
    credit=credit.toDomainPersonMovieCastAndCrew(),
    id=id
)

fun List<PersonMovieCastAndCrew>.toDomainPersonMovieCastAndCrew(): List<DomainPersonMovieCastAndCrew> {
    val list = mutableListOf<DomainPersonMovieCastAndCrew>()
    this.forEach { list.add(it.toDomainPersonMovieCastAndCrew()) }
    return list
}



