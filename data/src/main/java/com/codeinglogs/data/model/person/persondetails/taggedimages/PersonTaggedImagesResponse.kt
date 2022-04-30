package com.codeinglogs.data.model.person.persondetails.taggedimages

import com.codeinglogs.domain.model.person.persondetails.taggedimages.PersonTaggedImages as DomainPersonTaggedImages
import com.codeinglogs.domain.model.person.persondetails.taggedimages.PersonTaggedImagesResponse as DomainPersonTaggedImagesResponse

data class PersonTaggedImagesResponse(
    val id: Int,
    val results: List<PersonTaggedImages>,
)

fun PersonTaggedImagesResponse.toDomainPersonTaggedImagesResponse()= DomainPersonTaggedImagesResponse(
    id=id,
    results=results.toDomainTaggedImages(),
)

fun List<PersonTaggedImages>.toDomainTaggedImages():List<DomainPersonTaggedImages>{
    val list= mutableListOf<DomainPersonTaggedImages>()
    this.forEach { list.add(it.toDomainPersonTaggedImages()) }
    return list
}