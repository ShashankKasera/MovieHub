package com.codeinglogs.local.entity.person.externalids

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.codeinglogs.data.model.person.persondetails.externalids.PersonExternalIdsResponse as DataPersonExternalIdsResponse
@Entity
data class PersonExternalIdsResponse(
    @PrimaryKey
    val id: Int,
    val facebook_id: String,
    val imdb_id: String,
    val instagram_id: String,
    val twitter_id: String
)

fun PersonExternalIdsResponse.toDataPersonExternalIdsResponse() =
    DataPersonExternalIdsResponse(
        id=id,
        facebook_id =facebook_id,
        imdb_id =imdb_id,
        instagram_id =instagram_id,
        twitter_id =twitter_id
    )

fun DataPersonExternalIdsResponse.toLocalPersonExternalIdsResponse() = PersonExternalIdsResponse(
    id=id,
    facebook_id =facebook_id,
    imdb_id =imdb_id,
    instagram_id =instagram_id,
    twitter_id =twitter_id
)