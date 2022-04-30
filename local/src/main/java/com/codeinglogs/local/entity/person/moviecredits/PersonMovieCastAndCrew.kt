package com.codeinglogs.local.entity.person.moviecredits

import androidx.room.Entity
import androidx.room.PrimaryKey

import com.codeinglogs.data.model.person.persondetails.moviecredits.PersonMovieCastAndCrew as DataPersonMovieCastAndCrew
@Entity
data class PersonMovieCastAndCrew(
    @PrimaryKey
    val id: Long,
    val backdrop_path: String,
    val release_date: String,
    val vote_average: Double,
    val title: String,
    val original_title: String,

    )

fun PersonMovieCastAndCrew.toDataPersonMovieCastAndCrew() =
    DataPersonMovieCastAndCrew(
        backdrop_path =backdrop_path,
        release_date =release_date,
        vote_average=vote_average,
        title =title,
        id =id,
        original_title =original_title,
    )

fun List<PersonMovieCastAndCrew>.toDataPersonMovieCastAndCrew() : List<DataPersonMovieCastAndCrew>{
    val list = mutableListOf<DataPersonMovieCastAndCrew>()
    this.forEach { list.add(it.toDataPersonMovieCastAndCrew()) }
    return list
}

fun DataPersonMovieCastAndCrew.toLocalPersonMovieCastAndCrew() = PersonMovieCastAndCrew(
    backdrop_path =backdrop_path,
    release_date =release_date,
    vote_average=vote_average,
    title =title,
    id =id,
    original_title =original_title,
)

fun List<DataPersonMovieCastAndCrew>.toLocalPersonMovieCastAndCrewList() : List<PersonMovieCastAndCrew>{
    val list = mutableListOf<PersonMovieCastAndCrew>()
    this.forEach { list.add(it.toLocalPersonMovieCastAndCrew()) }
    return list
}
