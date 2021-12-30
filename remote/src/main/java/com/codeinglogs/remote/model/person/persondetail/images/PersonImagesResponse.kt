package com.codeinglogs.remote.model.person.persondetail.images

import com.codeinglogs.data.model.person.persondetails.images.PersonImages as DataPersonImages
import com.codeinglogs.data.model.person.persondetails.images.PersonImagesResponse as DataPersonImagesResponse

data class PersonImagesResponse(
    val id: Int?,
    val profiles: List<PersonImages>?
)

fun PersonImagesResponse.toDataPersonImagesResponse()=DataPersonImagesResponse(
    id=id?:0,
    profiles=profiles?.toDataPersonImages()?: listOf()
)

fun List<PersonImages>.toDataPersonImages():List<DataPersonImages>{
    val list= mutableListOf<DataPersonImages>()
    this.forEach { list.add(it.toDataPersonImages()) }
    return list

}