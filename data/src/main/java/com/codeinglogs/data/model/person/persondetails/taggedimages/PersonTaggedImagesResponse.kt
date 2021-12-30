package com.codeinglogs.data.model.person.persondetails.taggedimages

import com.codeinglogs.domain.model.person.persondetails.taggedimages.PersonTaggedImages as DomainPersonTaggedImages
import com.codeinglogs.domain.model.person.persondetails.taggedimages.PersonTaggedImagesResponse as DomainPersonTaggedImagesResponse

data class PersonTaggedImagesResponse(
    val id: Int,
    val page: Int,
    val results: List<PersonTaggedImages>,
    val total_pages: Int,
    val total_results: Int
)

fun PersonTaggedImagesResponse.toDomainPersonTaggedImagesResponse()= DomainPersonTaggedImagesResponse(
    id=id,
    page=page,
    results=results.toDomainTaggedImages(),
    total_pages=total_pages,
    total_results=total_results
)

fun List<PersonTaggedImages>.toDomainTaggedImages():List<DomainPersonTaggedImages>{
    val list= mutableListOf<DomainPersonTaggedImages>()
    this.forEach { list.add(it.toDomainPersonTaggedImages()) }
    return list
}