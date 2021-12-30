package com.codeinglogs.presentation.model.person.persondetails.images
import  com.codeinglogs.domain.model.person.persondetails.images.PersonImagesResponse as DomainPersonImagesResponse
import  com.codeinglogs.domain.model.person.persondetails.images.PersonImages as DomainPersonImages
data class PersonImagesResponse(
    val id: Int,
    val profiles: List<PersonImages>
)

fun DomainPersonImagesResponse.toPresentationPersonImagesResponse()= PersonImagesResponse(
        id = id,
        profiles = profiles.toPresentationPersonImages()
)

fun List<DomainPersonImages>.toPresentationPersonImages():List<PersonImages>{
    val list= mutableListOf<PersonImages>()
    this.forEach { list.add(it.toPresentationPersonImages()) }
    return list

}