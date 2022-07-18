package com.codeinglogs.domain.model.person.persondetails.info

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