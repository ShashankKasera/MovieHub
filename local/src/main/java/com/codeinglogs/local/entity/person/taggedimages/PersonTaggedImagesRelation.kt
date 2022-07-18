package com.codeinglogs.local.entity.person.taggedimages

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.data.model.person.persondetails.moviecredits.PersonMovieCastAndCrew
import com.codeinglogs.local.entity.person.info.PersonInfoResponse
import com.codeinglogs.util.getId

import com.codeinglogs.data.model.person.persondetails.taggedimages.PersonTaggedImages as DataPersonTaggedImages
@Entity(
    foreignKeys = [
        ForeignKey(
            entity = PersonTaggedImages::class,
            parentColumns = ["file_path"],
            childColumns = ["personTaggedImagesFilePath"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = PersonInfoResponse::class,
            parentColumns = ["id"],
            childColumns = ["personId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class PersonTaggedImagesRelation(
    @PrimaryKey(autoGenerate = false)
    val id : String,
    val personTaggedImagesFilePath : String,
    val personId : String
)

fun DataPersonTaggedImages.toLocalPersonTaggedImagesRelation(personId : String) =
    PersonTaggedImagesRelation(getId(personId,file_path), personTaggedImagesFilePath=file_path,personId=personId)



fun List<DataPersonTaggedImages>.toLocalPersonTaggedImagesRelationList(personId : String) : List<PersonTaggedImagesRelation>{
    val list = mutableListOf<PersonTaggedImagesRelation>()
    this.forEach { list.add(it.toLocalPersonTaggedImagesRelation(personId)) }
    return list
}