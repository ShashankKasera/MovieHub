package com.codeinglogs.remote.model.person

import com.codeinglogs.data.model.person.Result as DataResult
import com.codeinglogs.data.model.person.PersonList as DataPersonList

data class PersonList(
    val page: Int?,
    val results: List<Result>?,
    val total_pages: Int?,
    val total_results: Int?
)

fun PersonList.toDataPersonList() = DataPersonList(
        page=page?:0,
        total_pages=total_pages?:0,
        total_results=total_results?:0,
        results=results?.toDataPersonResultList()?: listOf()
    )
fun List<Result>.toDataPersonResultList() : List<DataResult>{
    val list = mutableListOf<DataResult>()
    this.forEach { list.add(it.toDataPersonResult()) }
    return list
}