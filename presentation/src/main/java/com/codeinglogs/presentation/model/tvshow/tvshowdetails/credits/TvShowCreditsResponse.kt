package com.codeinglogs.presentation.model.tvshow.tvshowdetails.credits

import com.codeinglogs.presentation.model.person.personlist.Person
import com.codeinglogs.presentation.model.person.personlist.toPresentationPerson
import com.codeinglogs.domain.model.tvshow.tvshowdetails.credits.TvShowCreditsResponse as DomainTvShowCreditsResponse

data class TvShowCreditsResponse(
    val cast: List<Person>,
    val crew: List<Person>,
    val id: Int
)

fun DomainTvShowCreditsResponse.toPresentationTvShowCreditsResponse()= TvShowCreditsResponse(
    cast=cast.toPresentationPerson(),
    crew=crew.toPresentationPerson(),
    id=id
)
