package com.codeinglogs.domain.model.person.persondetails.taggedimages

data class PersonTaggedImagesResponse(
    val id: Int,
    val page: Int,
    val results: List<PersonTaggedImages>,
    val total_pages: Int,
    val total_results: Int
)