package com.codeinglogs.remote.model.person.persondetail.tvcredits
import com.codeinglogs.data.model.person.persondetails.tvcredits.PersonTvCastAndCrew as DataPersonTvCastAndCrew
import com.codeinglogs.data.model.person.persondetails.tvcredits.PersonTvCreditsResponse as DataPersonTvCreditsResponse

data class PersonTvCreditsResponse(
    val cast: List<PersonTvCast>?,
    val crew: List<PersonTvCrew>?,
    val id: Int?
)

fun PersonTvCreditsResponse.toDataPersonTvCreditsResponse() =DataPersonTvCreditsResponse (
        credit = getPersonTvCreditsList(this).toDataPersonCastAndCrew(),
        id = id ?: 0
    )

fun getPersonTvCreditsList(response: PersonTvCreditsResponse): List<PersonTvCastAndCrew> {
    val list = mutableListOf<PersonTvCastAndCrew>()
    response.cast?.forEach {
        list.add(
            PersonTvCastAndCrew(
                it.backdrop_path?:"",
                it.vote_average?:0.0,
                it.first_air_date?:"",
                it.name?:"",
                it.id?:0
                )
        )
    }
    response.crew?.forEach {
        list.add(
            PersonTvCastAndCrew(
                it.backdrop_path?:"",
                it.vote_average?:0.0,
                it.first_air_date?:"",
                it.name?:"",
                it.id?:0

                )
        )
    }

    return list
}


fun List<PersonTvCastAndCrew>.toDataPersonCastAndCrew(): List<DataPersonTvCastAndCrew> {
    val list = mutableListOf<DataPersonTvCastAndCrew>()
    this.forEach { list.add(it.toDataPersonTvCastAndCrew()) }
    return list
}

