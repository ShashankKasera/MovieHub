package com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasoncredits

import com.codeinglogs.data.model.person.personlist.Person
import com.codeinglogs.data.model.person.personlist.toDomainPerson
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasoncredits.TvShowSeasonsCreditsResponse as DomainTvShowSeasonsCreditsResponse


data class TvShowSeasonsCreditsResponse(
    val cast: List<Person>,
    val crew: List<Person>,
    val id: Int
)

fun TvShowSeasonsCreditsResponse.toDomainTvShowSeasonsCreditsResponse()= DomainTvShowSeasonsCreditsResponse(
    cast=cast.toDomainPerson(),
    crew=crew.toDomainPerson(),
    id=id
)
