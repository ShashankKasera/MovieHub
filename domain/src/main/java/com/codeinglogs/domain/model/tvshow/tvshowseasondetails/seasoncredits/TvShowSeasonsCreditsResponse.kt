package com.codeinglogs.domain.model.tvshow.tvshowseasondetails.seasoncredits

import com.codeinglogs.domain.model.person.personlist.Person

data class TvShowSeasonsCreditsResponse(
    val cast: List<Person>,
    val crew: List<Person>,
    val id: Int
)