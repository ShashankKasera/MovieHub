package com.codeinglogs.data.model.person.persondetails.tvcredits
import com.codeinglogs.domain.model.person.persondetails.tvcredits.PersonTvCastAndCrew as DomainPersonTvCastAndCrew

data class PersonTvCastAndCrew (
    val backdrop_path: String,
    val vote_average: Double,
    val first_air_date: String,
    val name: String,
    val id: Long,
)
fun PersonTvCastAndCrew.toDomainPersonTvCastAndCrew()=DomainPersonTvCastAndCrew(
    backdrop_path =backdrop_path,
    vote_average=vote_average,
    first_air_date =first_air_date,
    name =name,
    id=id,
)