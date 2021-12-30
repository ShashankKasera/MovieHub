package com.codeinglogs.data.model.person.persondetails.moviecredits
import com.codeinglogs.domain.model.person.persondetails.moviecredits.PersonMovieCastAndCrew as DomainPersonMovieCastAndCrew

data class PersonMovieCastAndCrew(
    val backdrop_path: String,
    val release_date: String,
    val vote_average: Double,
    val title: String,
    val id: Int,
    val original_title: String,
)

fun PersonMovieCastAndCrew.toDomainPersonMovieCastAndCrew()=DomainPersonMovieCastAndCrew(
        backdrop_path =backdrop_path,
        release_date =release_date,
        vote_average=vote_average,
        title =title,
        id =id,
        original_title =original_title,
)
