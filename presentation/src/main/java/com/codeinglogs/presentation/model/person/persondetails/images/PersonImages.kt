package com.codeinglogs.presentation.model.person.persondetails.images
import  com.codeinglogs.domain.model.person.persondetails.images.PersonImages as DomainPersonImages

data class PersonImages(

    val file_path: String,
)

fun DomainPersonImages.toPresentationPersonImages()=PersonImages(

    file_path=file_path
)

