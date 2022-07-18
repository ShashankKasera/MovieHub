package com.codeinglogs.local.entity.person.info
import androidx.room.Entity
import androidx.room.PrimaryKey
import  com.codeinglogs.data.model.person.persondetails.info.PersonInfoResponse as DataPersonInfoResponse

@Entity
data class PersonInfoResponse(
    @PrimaryKey
    val id: Int,
    val biography: String,
    val birthday: String,
    val deathday: String,
    val imdb_id: String,
    val known_for_department: String,
    val name: String,
    val place_of_birth: String,
    val profile_path: String
)

fun PersonInfoResponse.toDataPersonInfoResponse() = DataPersonInfoResponse(

        biography =biography,
        birthday =birthday,
        deathday =deathday,
        id =id,
        imdb_id =imdb_id,
        known_for_department =known_for_department,
        name =name,
        place_of_birth =place_of_birth,
        profile_path =profile_path
    )

fun DataPersonInfoResponse.toLocalPersonInfoResponse() = PersonInfoResponse(

    biography =biography,
    birthday =birthday,
    deathday =deathday,
    id =id,
    imdb_id =imdb_id,
    known_for_department =known_for_department,
    name =name,
    place_of_birth =place_of_birth,
    profile_path =profile_path
)