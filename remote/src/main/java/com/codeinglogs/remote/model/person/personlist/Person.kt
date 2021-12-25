package com.codeinglogs.remote.model.person.personlist

import com.codeinglogs.data.model.person.personlist.Person as DataPerson

data class Person(
    val adult: Boolean?,
    val gender: Int?,
    val id: Long?,
    val known_for: List<KnownFor>?,
    val known_for_department: String?,
    val name: String?,
    val popularity: Double?,
    val profile_path: String
)

fun Person.toDataPerson() = DataPerson(
    id=id?:0,
    known_for_department=known_for_department?:"",
    name=name?:"",
    profile_path=profile_path?:"",
)
