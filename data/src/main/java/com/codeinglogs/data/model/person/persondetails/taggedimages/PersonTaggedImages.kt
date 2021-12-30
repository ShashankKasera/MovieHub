package com.codeinglogs.data.model.person.persondetails.taggedimages

import com.codeinglogs.domain.model.person.persondetails.taggedimages.PersonTaggedImages as DomainPersonTaggedImages

data class PersonTaggedImages(
    val file_path: String,
)

fun PersonTaggedImages.toDomainPersonTaggedImages()=DomainPersonTaggedImages(
    file_path=file_path
)
