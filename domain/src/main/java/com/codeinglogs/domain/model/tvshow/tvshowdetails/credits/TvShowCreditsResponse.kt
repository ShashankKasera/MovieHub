package com.codeinglogs.domain.model.tvshow.tvshowdetails.credits

import com.codeinglogs.domain.model.person.personlist.Person

data class TvShowCreditsResponse(
    val cast: List<Person>,
    val crew: List<Person>,
    val id: Int
)