package com.codeinglogs.local.entity.person.image

import androidx.room.Entity
import androidx.room.PrimaryKey

import com.codeinglogs.data.model.person.persondetails.images.PersonImages as DataPersonImages
@Entity
data class PersonImages(
    @PrimaryKey
        val file_path: String,
    )

fun PersonImages.toDataPersonImages() =
    DataPersonImages(
        file_path=file_path
    )

fun List<PersonImages>.toDataPersonImages() : List<DataPersonImages>{
    val list = mutableListOf<DataPersonImages>()
    this.forEach { list.add(it.toDataPersonImages()) }
    return list
}

fun DataPersonImages.toLocalPersonImages() = PersonImages(
    file_path=file_path
)

fun List<DataPersonImages>.toLocalPersonImagesList() : List<PersonImages>{
    val list = mutableListOf<PersonImages>()
    this.forEach { list.add(it.toLocalPersonImages()) }
    return list
}
