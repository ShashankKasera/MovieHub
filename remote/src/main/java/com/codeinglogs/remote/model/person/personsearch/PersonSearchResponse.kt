package com.codeinglogs.remote.model.person.personsearch

import com.codeinglogs.remote.model.person.personlist.Person


data class PersonSearchResponse(
    val page: Int?,
    val results: List<Person>?,
    val total_pages: Int?,
    val total_results: Int?
)