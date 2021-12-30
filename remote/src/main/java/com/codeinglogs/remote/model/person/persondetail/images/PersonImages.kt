package com.codeinglogs.remote.model.person.persondetail.images
import com.codeinglogs.data.model.person.persondetails.images.PersonImages as DataPersonImages

data class PersonImages(
    val aspect_ratio: Double?,
    val file_path: String?,
    val height: Int?,
    val iso_639_1: Any?,
    val vote_average: Double?,
    val vote_count: Int?,
    val width: Int?
)

fun PersonImages.toDataPersonImages()=DataPersonImages(
    file_path=file_path?:""
)