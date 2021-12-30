package com.codeinglogs.presentation.model.person.persondetails.taggedimages

import com.codeinglogs.domain.model.person.persondetails.taggedimages.PersonTaggedImages as DomainPersonTaggedImages

data class PersonTaggedImages(
    val file_path: String,
)

fun DomainPersonTaggedImages.toPresentationPersonTaggedImages()=PersonTaggedImages(
        file_path = file_path
)
