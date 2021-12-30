package com.codeinglogs.remote.model.person.persondetail.tvcredits
import com.codeinglogs.data.model.person.persondetails.tvcredits.PersonTvCastAndCrew as DataPersonTvCastAndCrew

data class PersonTvCastAndCrew (
    val backdrop_path: String,
    val vote_average: Double,
    val first_air_date: String,
    val name: String,
    val id: Int,
)
fun PersonTvCastAndCrew.toDataPersonTvCastAndCrew()=DataPersonTvCastAndCrew(
    backdrop_path =backdrop_path,
    vote_average=vote_average,
    first_air_date =first_air_date,
    name =name,
    id=id,
)