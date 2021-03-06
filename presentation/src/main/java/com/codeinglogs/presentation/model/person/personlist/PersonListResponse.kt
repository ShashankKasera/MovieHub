package com.codeinglogs.presentation.model.person.personlist

import com.codeinglogs.domain.model.person.personlist.PersonListResponse as DomainPersonListResponse
import com.codeinglogs.domain.model.person.personlist.Person as DomainPerson

data class PersonListResponse(
    val page: Int? = null,
    val results: List<Person>,
    val total_pages: Int? = null,
    val total_results: Int? = null
)

fun DomainPersonListResponse.toPresentationPersonListResponse() =
    PersonListResponse(
        page=page,
        total_pages=total_pages,
        total_results=total_results,
        results=results.toPresentationPerson()
    )
fun List<DomainPerson>.toPresentationPerson() : List<Person>{
    val list = mutableListOf<Person>()
    this.forEach { list.add(it.toPresentationPerson()) }
    return list
}