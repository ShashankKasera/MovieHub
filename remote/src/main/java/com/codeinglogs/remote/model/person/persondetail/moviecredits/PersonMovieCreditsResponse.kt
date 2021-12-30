package com.codeinglogs.remote.model.person.persondetail.moviecredits

import com.codeinglogs.data.model.person.persondetails.moviecredits.PersonMovieCreditsResponse as DataPersonMovieCreditsResponse
import com.codeinglogs.data.model.person.persondetails.moviecredits.PersonMovieCastAndCrew as DataPersonMovieCastAndCrew

data class PersonMovieCreditsResponse(
    val cast: List<PersonMovieCast>?,
    val crew: List<PersonMovieCrew>?,
    val id: Int?
)

fun PersonMovieCreditsResponse.toDataPersonMovieCreditsResponse() = DataPersonMovieCreditsResponse(
    credit = getPersonMovieCreditsList(this).toDataPersonCastAndCrew(),
    id = id ?: 0
)

fun getPersonMovieCreditsList(response: PersonMovieCreditsResponse): List<PersonMovieCastAndCrew> {
    val list = mutableListOf<PersonMovieCastAndCrew>()
    response.cast?.forEach {
        list.add(
            PersonMovieCastAndCrew(
                it.backdrop_path ?: "",
                it.release_date ?: "",
                it.vote_average ?: 0.0,
                it.title ?: "",
                it.id?:0,
                it.original_title ?: "",

                )
        )
    }
    response.crew?.forEach {
        list.add(
            PersonMovieCastAndCrew(
                it.backdrop_path ?: "",
                it.release_date ?: "",
                it.vote_average ?: 0.0,
                it.title ?: "",
                it.id?:0,
                it.original_title ?: "",

                )
        )
    }

    return list
}

fun List<PersonMovieCastAndCrew>.toDataPersonCastAndCrew(): List<DataPersonMovieCastAndCrew> {
    val list = mutableListOf<DataPersonMovieCastAndCrew>()
    this.forEach { list.add(it.toDataPersonMovieCastAndCrew()) }
    return list
}

