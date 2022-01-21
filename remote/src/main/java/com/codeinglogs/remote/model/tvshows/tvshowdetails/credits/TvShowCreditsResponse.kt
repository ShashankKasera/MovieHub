package com.codeinglogs.remote.model.tvshows.tvshowdetails.credits

import com.codeinglogs.remote.model.person.personlist.Person
import com.codeinglogs.remote.model.person.personlist.toDataPerson
import com.codeinglogs.data.model.tvshow.tvshowdetails.credits.TvShowCreditsResponse as DataTvShowCreditsResponse


data class TvShowCreditsResponse(
    val cast: List<Person>?,
    val crew: List<Person>?,
    val id: Int?
)

fun TvShowCreditsResponse.toDataTvShowCreditsResponse()=DataTvShowCreditsResponse(
    cast=cast?.toDataPerson()?: listOf(),
    crew=crew?.toDataPerson()?: listOf(),
    id=id?:0
)
