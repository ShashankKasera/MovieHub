package com.codeinglogs.data.model.tvshow.tvshowdetails.credits

import com.codeinglogs.data.model.person.personlist.Person
import com.codeinglogs.data.model.person.personlist.toDomainPerson
import com.codeinglogs.domain.model.tvshow.tvshowdetails.credits.TvShowCreditsResponse as domainTvShowCreditsResponse


data class TvShowCreditsResponse(
    val cast: List<Person>,
    val crew: List<Person>,
    val id: Int
)


fun TvShowCreditsResponse.toDomainTvShowCreditsResponse()= domainTvShowCreditsResponse(
    cast=cast.toDomainPerson(),
    crew=crew.toDomainPerson(),
    id=id
)
