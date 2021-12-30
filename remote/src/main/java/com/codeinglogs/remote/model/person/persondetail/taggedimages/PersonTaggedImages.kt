package com.codeinglogs.remote.model.person.persondetail.taggedimages
import com.codeinglogs.data.model.person.persondetails.taggedimages.PersonTaggedImages as DataPersonTaggedImages

data class PersonTaggedImages(
    val aspect_ratio: Double?,
    val file_path: String?,
    val height: Int?,
    val id: String?,
    val image_type: String?,
    val iso_639_1: String?,
    val media: Media?,
    val media_type: String?,
    val vote_average: Double?,
    val vote_count: Int?,
    val width: Int?
)

fun PersonTaggedImages.toDataPersonTaggedImages()=DataPersonTaggedImages(
    file_path=file_path?:""
)