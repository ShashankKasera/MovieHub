package com.codeinglogs.remote.model.person.personlist

import com.codeinglogs.data.model.person.personlist.Person as DataPerson
import com.codeinglogs.data.model.person.personlist.PersonListResponse as DataPersonListResponse

data class PersonListResponse(
    val page: Int?,
    val results: List<Person>?,
    val total_pages: Int?,
    val total_results: Int?
)

fun PersonListResponse.toDataPersonListResponse() = DataPersonListResponse(
        page=page?:0,
        total_pages=total_pages?:0,
        total_results=total_results?:0,
        results=results?.toDataPerson()?: listOf()
    )
fun List<Person>.toDataPerson() : List<DataPerson>{
    val list = mutableListOf<DataPerson>()
    this.forEach { list.add(it.toDataPerson()) }
    return list
}