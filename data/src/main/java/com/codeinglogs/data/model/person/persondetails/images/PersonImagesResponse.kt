package com.codeinglogs.data.model.person.persondetails.images
import com.codeinglogs.domain.model.person.persondetails.images.PersonImages as DomainPersonImages
import com.codeinglogs.domain.model.person.persondetails.images.PersonImagesResponse as DomainPersonImagesResponse

data class PersonImagesResponse(
    val id: Int,
    val profiles: List<PersonImages>
)

fun PersonImagesResponse.toDomainPersonImagesResponse()=DomainPersonImagesResponse (
    id=id,
    profiles=profiles.toDomainPersonImages()
)

fun List<PersonImages>.toDomainPersonImages():List<DomainPersonImages>{
    val list= mutableListOf<DomainPersonImages>()
    this.forEach { list.add(it.toDomainPersonImages()) }
    return list

}