package com.codeinglogs.data.model.person.personlist

import com.codeinglogs.domain.model.person.personlist.PersonListResponce as DomainPersonListResponce
import com.codeinglogs.domain.model.person.personlist.Person as DomainPerson

data class PersonListResponce(
    val page: Int,
    val results: List<Person>,
    val total_pages: Int,
    val total_results: Int
)

fun PersonListResponce.toDomainPersonListResponce() =
    DomainPersonListResponce(
        page=page,
        total_pages=total_pages,
        total_results=total_results,
        results=results.toDomainPersonResultList()
    )
fun List<Person>.toDomainPersonResultList() : List<DomainPerson>{
    val list = mutableListOf<DomainPerson>()
    this.forEach { list.add(it.toDomainPerson()) }
    return list
}