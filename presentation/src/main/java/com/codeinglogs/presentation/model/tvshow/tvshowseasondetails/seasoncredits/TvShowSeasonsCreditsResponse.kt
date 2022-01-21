package com.codeinglogs.presentation.model.tvshow.tvshowseasondetails.seasoncredits

import com.codeinglogs.presentation.model.person.personlist.Person
import com.codeinglogs.presentation.model.person.personlist.toPresentationPerson
import com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasoncredits.TvShowSeasonsCreditsResponse as DomainTvShowSeasonsCreditsResponse


data class TvShowSeasonsCreditsResponse(
    val cast: List<Person>,
    val crew: List<Person>,
    val id: Int
)

fun DomainTvShowSeasonsCreditsResponse.toPresentationTvShowSeasonsCreditsResponse()= TvShowSeasonsCreditsResponse(
    cast=cast.toPresentationPerson(),
    crew=crew.toPresentationPerson(),
    id=id
)
