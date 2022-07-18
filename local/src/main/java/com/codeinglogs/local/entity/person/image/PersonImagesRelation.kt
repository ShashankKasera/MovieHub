package com.codeinglogs.local.entity.person.image

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.local.entity.person.info.PersonInfoResponse
import com.codeinglogs.util.getId
import com.codeinglogs.data.model.person.persondetails.images.PersonImages as DataPersonImages

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = PersonImages::class,
            parentColumns = ["file_path"],
            childColumns = ["PersonImagesFilePath"],
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
data class PersonImagesRelation(
    @PrimaryKey(autoGenerate = false)
    val id : String,
    val PersonImagesFilePath : String,
    val personId : String
)

fun DataPersonImages.toLocalPersonImagesRelation(personId : String) =
    PersonImagesRelation(getId(personId,file_path), PersonImagesFilePath=file_path,personId=personId)



fun List<DataPersonImages>.toLocalPersonImagesRelationList(personId : String) : List<PersonImagesRelation>{
    val list = mutableListOf<PersonImagesRelation>()
    this.forEach { list.add(it.toLocalPersonImagesRelation(personId)) }
    return list
}