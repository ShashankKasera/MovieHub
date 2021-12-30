package com.codeinglogs.presentation.model.person.persondetails.tvcredits

import com.codeinglogs.domain.model.person.persondetails.tvcredits.PersonTvCastAndCrew as DomainPersonTvCastAndCrew
import com.codeinglogs.domain.model.person.persondetails.tvcredits.PersonTvCreditsResponse as DomainPersonTvCreditsResponse


data class PersonTvCreditsResponse(
    val credit:List<PersonTvCastAndCrew>,
    val id: Int
)

fun DomainPersonTvCreditsResponse.toPresentationPersonTvCreditsResponse()= PersonTvCreditsResponse(
    credit = credit.toPresentationPersonTvCastAndCrew(),
    id = id
)

fun List<DomainPersonTvCastAndCrew>.toPresentationPersonTvCastAndCrew(): List<PersonTvCastAndCrew> {
    val list = mutableListOf<PersonTvCastAndCrew>()
    this.forEach { list.add(it.toPresentationPersonTvCastAndCrew()) }
    return list
}
