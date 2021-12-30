package com.codeinglogs.domain.model.person.persondetails.tvcredits

data class PersonTvCreditsResponse(
    val credit:List<PersonTvCastAndCrew>,
    val id: Int
)