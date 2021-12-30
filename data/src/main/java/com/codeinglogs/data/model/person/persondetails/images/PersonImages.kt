package com.codeinglogs.data.model.person.persondetails.images

import com.codeinglogs.domain.model.person.persondetails.images.PersonImages as DomainPersonImages
data class PersonImages(
    val file_path: String,
)

fun PersonImages.toDomainPersonImages()=DomainPersonImages(
    file_path=file_path
)