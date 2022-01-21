package com.codeinglogs.remote.model.tvshows.tvshowseasondetails.seasoncredits

import com.codeinglogs.remote.model.person.personlist.Person
import com.codeinglogs.remote.model.person.personlist.toDataPerson
import com.codeinglogs.data.model.tvshow.tvshowseasondetails.seasoncredits.TvShowSeasonsCreditsResponse as DataTvShowSeasonsCreditsResponse

data class TvShowSeasonsCreditsResponse(
    val cast: List<Person>?,
    val crew: List<Person>?,
    val id: Int?
)

fun TvShowSeasonsCreditsResponse.toDataTvShowSeasonsCreditsResponse()=DataTvShowSeasonsCreditsResponse(
    cast=cast?.toDataPerson()?: listOf(),
    crew=crew?.toDataPerson()?: listOf(),
    id=id?:0
)

