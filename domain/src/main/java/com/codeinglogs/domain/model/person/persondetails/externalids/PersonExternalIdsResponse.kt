package com.codeinglogs.domain.model.person.persondetails.externalids

data class PersonExternalIdsResponse(
    val id: Int,
    val facebook_id: String,
    val imdb_id: String,
    val instagram_id: String,
    val twitter_id: String
)