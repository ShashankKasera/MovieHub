package com.codeinglogs.domain.model.person.personlist

data class Person(
    val id: Long,
    val known_for_department: String,
    val name: String,
    val character: String,
    val profile_path: Any
)
