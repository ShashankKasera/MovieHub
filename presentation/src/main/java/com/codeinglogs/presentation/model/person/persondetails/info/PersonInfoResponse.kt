package com.codeinglogs.presentation.model.person.persondetails.info
import com.codeinglogs.domain.model.person.persondetails.info.PersonInfoResponse as DomainPersonInfoResponse
data class PersonInfoResponse(

    val biography: String,
    val birthday: String,
    val deathday: String,
    val id: Int,
    val imdb_id: String,
    val known_for_department: String,
    val name: String,
    val place_of_birth: String,
    val profile_path: String
)

fun DomainPersonInfoResponse.toPresentationPersonInfoResponse()=PersonInfoResponse(
        biography = biography,
        birthday = birthday,
        deathday = deathday,
        id = id,
        imdb_id = imdb_id,
        known_for_department = known_for_department,
        name = name,
        place_of_birth = place_of_birth,
        profile_path = profile_path
    )