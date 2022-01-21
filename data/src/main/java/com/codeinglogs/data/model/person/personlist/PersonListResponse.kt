package com.codeinglogs.data.model.person.personlist

import com.codeinglogs.domain.model.person.personlist.PersonListResponse as DomainPersonListResponse
import com.codeinglogs.domain.model.person.personlist.Person as DomainPerson

data class PersonListResponse(
    val page: Int? = null,
    val results: List<Person>,
    val total_pages: Int? = null,
    val total_results: Int? = null
)

fun PersonListResponse.toDomainPersonListResponse() =
    DomainPersonListResponse(
        page=page,
        total_pages=total_pages,
        total_results=total_results,
        results=results.toDomainPerson()
    )
fun List<Person>.toDomainPerson() : List<DomainPerson>{
    val list = mutableListOf<DomainPerson>()
    this.forEach { list.add(it.toDomainPerson()) }
    return list
}