package com.codeinglogs.local.entity.person.taggedimages

import androidx.room.Entity
import androidx.room.PrimaryKey

import com.codeinglogs.data.model.person.persondetails.taggedimages.PersonTaggedImages as DataPersonTaggedImages
@Entity
data class PersonTaggedImages(
    @PrimaryKey
    val file_path: String,
)

fun PersonTaggedImages.toDataPersonTaggedImages() =
    DataPersonTaggedImages(
        file_path=file_path
    )

fun List<PersonTaggedImages>.toDataPersonTaggedImagesList() : List<DataPersonTaggedImages>{
    val list = mutableListOf<DataPersonTaggedImages>()
    this.forEach { list.add(it.toDataPersonTaggedImages()) }
    return list
}

fun DataPersonTaggedImages.toLocalPersonTaggedImages() = PersonTaggedImages(
    file_path=file_path
)

fun List<DataPersonTaggedImages>.toLocalPersonTaggedImagesList() : List<PersonTaggedImages>{
    val list = mutableListOf<PersonTaggedImages>()
    this.forEach { list.add(it.toLocalPersonTaggedImages()) }
    return list
}