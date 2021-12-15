package com.codeinglogs.presentation.model.person

import com.codeinglogs.domain.model.person.PersonList as DomainPersonList
import com.codeinglogs.domain.model.person.Result as DomainResult

data class PersonList(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)

fun DomainPersonList.toPresentationPersonList() =
    PersonList(
        page=page,
        total_pages=total_pages,
        total_results=total_results,
        results=results.toPresentationPersonResultList()
    )
fun List<DomainResult>.toPresentationPersonResultList() : List<Result>{
    val list = mutableListOf<Result>()
    this.forEach { list.add(it.toPresentationPersonResult()) }
    return list
}