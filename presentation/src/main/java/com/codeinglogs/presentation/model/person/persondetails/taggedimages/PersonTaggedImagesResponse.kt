package com.codeinglogs.presentation.model.person.persondetails.taggedimages

import com.codeinglogs.domain.model.person.persondetails.taggedimages.PersonTaggedImages as DomainPersonTaggedImages
import com.codeinglogs.domain.model.person.persondetails.taggedimages.PersonTaggedImagesResponse as DomainPersonTaggedImagesResponse

data class PersonTaggedImagesResponse(
    val id: Int,
    val results: List<PersonTaggedImages>,
)

fun DomainPersonTaggedImagesResponse.toPresentationPersonTaggedImagesResponse()= PersonTaggedImagesResponse(
    id=id,
    results=results.toPresentationPersonTaggedImages(),
)

fun List<DomainPersonTaggedImages>.toPresentationPersonTaggedImages():List<PersonTaggedImages>{
    val list= mutableListOf<PersonTaggedImages>()
    this.forEach { list.add(it.toPresentationPersonTaggedImages()) }
    return list
}