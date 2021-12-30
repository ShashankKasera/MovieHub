package com.codeinglogs.presentation.model.person.persondetails.taggedimages

import com.codeinglogs.domain.model.person.persondetails.taggedimages.PersonTaggedImages as DomainPersonTaggedImages
import com.codeinglogs.domain.model.person.persondetails.taggedimages.PersonTaggedImagesResponse as DomainPersonTaggedImagesResponse

data class PersonTaggedImagesResponse(
    val id: Int,
    val page: Int,
    val results: List<PersonTaggedImages>,
    val total_pages: Int,
    val total_results: Int
)

fun DomainPersonTaggedImagesResponse.toPresentationPersonTaggedImagesResponse()= PersonTaggedImagesResponse(
    id=id,
    page=page,
    results=results.toPresentationPersonTaggedImages(),
    total_pages=total_pages,
    total_results=total_results
)

fun List<DomainPersonTaggedImages>.toPresentationPersonTaggedImages():List<PersonTaggedImages>{
    val list= mutableListOf<PersonTaggedImages>()
    this.forEach { list.add(it.toPresentationPersonTaggedImages()) }
    return list
}