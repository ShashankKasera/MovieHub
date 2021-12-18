package com.codeinglogs.domain.model.person.personlist

data class PersonListResponce(
    val page: Int,
    val results: List<Person>,
    val total_pages: Int,
    val total_results: Int
)