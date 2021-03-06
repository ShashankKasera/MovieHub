package com.codeinglogs.remote.model.person.persondetail.taggedimages

import com.codeinglogs.data.model.person.persondetails.taggedimages.PersonTaggedImages as DataPersonTaggedImages
import com.codeinglogs.data.model.person.persondetails.taggedimages.PersonTaggedImagesResponse as DataPersonTaggedImagesResponse

data class PersonTaggedImagesResponse(
    val id: Int?,
    val page: Int?,
    val results: List<PersonTaggedImages>?,
    val total_pages: Int?,
    val total_results: Int?
)

fun PersonTaggedImagesResponse.toDataPersonTaggedImagesResponse()=DataPersonTaggedImagesResponse(
    id=id?:0,
    results=results?.toDataPersonTaggedImages()?: listOf(),
)

fun List<PersonTaggedImages>.toDataPersonTaggedImages():List<DataPersonTaggedImages>{
    val list= mutableListOf<DataPersonTaggedImages>()
    this.forEach { list.add(it.toDataPersonTaggedImages()) }
    return list
}