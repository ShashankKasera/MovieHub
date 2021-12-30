package com.codeinglogs.domain.model.person.personlist

data class PersonListResponse(
    val page: Int? = null,
    val results: List<Person>,
    val total_pages: Int? = null,
    val total_results: Int? = null
)