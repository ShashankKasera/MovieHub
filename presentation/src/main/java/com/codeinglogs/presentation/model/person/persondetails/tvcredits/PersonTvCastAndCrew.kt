package com.codeinglogs.presentation.model.person.persondetails.tvcredits
import com.codeinglogs.domain.model.person.persondetails.tvcredits.PersonTvCastAndCrew as DomainPersonTvCastAndCrew

data class PersonTvCastAndCrew (
    val backdrop_path: String,
    val vote_average: Double,
    val id: Long,
    val first_air_date: String,
    val name: String,

)
fun DomainPersonTvCastAndCrew.toPresentationPersonTvCastAndCrew()=PersonTvCastAndCrew(
    backdrop_path =backdrop_path,
    first_air_date =first_air_date,
    name =name,
    vote_average=vote_average,
    id=id,

)