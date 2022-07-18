package com.codeinglogs.data.model.person.persondetails.tvcredits

import com.codeinglogs.domain.model.person.persondetails.tvcredits.PersonTvCastAndCrew as DomainPersonTvCastAndCrew
import com.codeinglogs.domain.model.person.persondetails.tvcredits.PersonTvCreditsResponse as DomainPersonTvCreditsResponse


data class PersonTvCreditsResponse(
    val id: Int,
    val credit:List<PersonTvCastAndCrew>,
)

fun PersonTvCreditsResponse.toDomainPersonTvCreditsResponse()=DomainPersonTvCreditsResponse(
        credit = credit.toDomainPersonTvCastAndCrew(),
        id = id
    )

fun List<PersonTvCastAndCrew>.toDomainPersonTvCastAndCrew(): List<DomainPersonTvCastAndCrew> {
    val list = mutableListOf<DomainPersonTvCastAndCrew>()
    this.forEach { list.add(it.toDomainPersonTvCastAndCrew()) }
    return list
}

