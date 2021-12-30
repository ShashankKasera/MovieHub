package com.codeinglogs.data.model.person.persondetails.externalids
import com.codeinglogs.domain.model.person.persondetails.externalids.PersonExternalIdsResponse as DomainPersonExternalIdsResponse

data class PersonExternalIdsResponse(
    val facebook_id: String,
    val imdb_id: String,
    val instagram_id: String,
    val twitter_id: String
)

fun PersonExternalIdsResponse.toDomainPersonExternalIdsResponse()= DomainPersonExternalIdsResponse(
    facebook_id =facebook_id,
    imdb_id =imdb_id,
    instagram_id =instagram_id,
    twitter_id =twitter_id
)