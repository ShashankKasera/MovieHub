package com.codeinglogs.remote.model.person.persondetail.info
import com.codeinglogs.data.model.person.persondetails.info.PersonInfoResponse as DataPersonInfoResponse

data class PersonInfoResponse(
    val adult: Boolean?,
    val also_known_as: List<String>?,
    val biography: String?,
    val birthday: String?,
    val deathday: String?,
    val gender: Int?,
    val homepage: Any?,
    val id: Int?,
    val imdb_id: String?,
    val known_for_department: String?,
    val name: String?,
    val place_of_birth: String?,
    val popularity: Double?,
    val profile_path: String?
)

fun PersonInfoResponse.toDataPersonInfoResponse()=DataPersonInfoResponse(
    also_known_as = also_known_as?: listOf(),
    biography =biography?:"",
    birthday =birthday?:"",
    deathday =deathday?:"",
    id =id?:0,
    imdb_id =imdb_id?:"",
    known_for_department =known_for_department?:"",
    name =name?:"",
    place_of_birth =place_of_birth?:"",
    profile_path =profile_path?:""
)