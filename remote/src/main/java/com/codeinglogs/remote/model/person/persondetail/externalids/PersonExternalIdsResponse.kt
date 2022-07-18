package com.codeinglogs.remote.model.person.persondetail.externalids
import com.codeinglogs.data.model.person.persondetails.externalids.PersonExternalIdsResponse as DataPersonExternalIdsResponse


data class PersonExternalIdsResponse(
    val facebook_id: String?,
    val freebase_id: String?,
    val freebase_mid: String?,
    val id: Int?,
    val imdb_id: String?,
    val instagram_id: String?,
    val tvrage_id: Int?,
    val twitter_id: String?
)

fun PersonExternalIdsResponse.toDataPersonExternalIdsResponse()=DataPersonExternalIdsResponse(
    id=id?:0,
    facebook_id =facebook_id?:"",
    imdb_id =imdb_id?:"",
    instagram_id =instagram_id?:"",
    twitter_id =twitter_id?:""
)