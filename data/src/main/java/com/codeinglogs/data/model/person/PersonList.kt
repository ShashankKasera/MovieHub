package com.codeinglogs.data.model.person

import com.codeinglogs.domain.model.person.PersonList as DomainPersonList
import com.codeinglogs.domain.model.person.Result as DomainResult

data class PersonList(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)

fun PersonList.toDomainPersonList() =
    DomainPersonList(
        page=page,
        total_pages=total_pages,
        total_results=total_results,
        results=results.toDomainPersonResultList()
    )
fun List<Result>.toDomainPersonResultList() : List<DomainResult>{
    val list = mutableListOf<DomainResult>()
    this.forEach { list.add(it.toDomainPersonResult()) }
    return list
}