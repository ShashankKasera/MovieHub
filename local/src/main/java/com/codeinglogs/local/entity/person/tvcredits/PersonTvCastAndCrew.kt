package com.codeinglogs.local.entity.person.tvcredits
import androidx.room.Entity
import androidx.room.PrimaryKey

import com.codeinglogs.data.model.person.persondetails.tvcredits.PersonTvCastAndCrew as DataPersonTvCastAndCrew
@Entity
data class PersonTvCastAndCrew(
    @PrimaryKey
    val id: Long,
    val backdrop_path: String,
    val vote_average: Double,
    val first_air_date: String,
    val name: String,

)

fun PersonTvCastAndCrew.toDataPersonTvCastAndCrew() =
    DataPersonTvCastAndCrew(
        backdrop_path =backdrop_path,
        vote_average=vote_average,
        first_air_date =first_air_date,
        name =name,
        id=id,
    )

fun List<PersonTvCastAndCrew>.toDataPersonTvCastAndCrew() : List<DataPersonTvCastAndCrew>{
    val list = mutableListOf<DataPersonTvCastAndCrew>()
    this.forEach { list.add(it.toDataPersonTvCastAndCrew()) }
    return list
}

fun DataPersonTvCastAndCrew.toLocalPersonTvCastAndCrew() = PersonTvCastAndCrew(
    backdrop_path =backdrop_path,
    vote_average=vote_average,
    first_air_date =first_air_date,
    name =name,
    id=id,
)

fun List<DataPersonTvCastAndCrew>.toLocalPersonTvCastAndCrewList() : List<PersonTvCastAndCrew>{
    val list = mutableListOf<PersonTvCastAndCrew>()
    this.forEach { list.add(it.toLocalPersonTvCastAndCrew()) }
    return list
}
