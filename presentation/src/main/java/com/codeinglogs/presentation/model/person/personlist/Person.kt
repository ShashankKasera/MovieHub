package com.codeinglogs.presentation.model.person.personlist

import com.codeinglogs.domain.model.person.personlist.Person as DomainPerson

data class Person(

    val id: Long,
    val known_for_department: String,
    val name: String,
    val profile_path: Any
)

fun DomainPerson.toPresentationPerson() = Person(
    id=id,
    known_for_department=known_for_department,
    name=name,
    profile_path=profile_path,
)
