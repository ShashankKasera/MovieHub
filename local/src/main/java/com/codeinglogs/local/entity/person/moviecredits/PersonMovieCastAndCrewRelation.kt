package com.codeinglogs.local.entity.person.moviecredits

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.local.entity.person.info.PersonInfoResponse
import com.codeinglogs.util.getId
import com.codeinglogs.data.model.person.persondetails.moviecredits.PersonMovieCastAndCrew as DataPersonMovieCastAndCrew

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = PersonMovieCastAndCrew::class,
            parentColumns = ["id"],
            childColumns = ["personMovieCastAndCrewId"],
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
data class PersonMovieCastAndCrewRelation(
    @PrimaryKey(autoGenerate = false)
    val id : String,
    val personMovieCastAndCrewId : String,
    val personId : String
)

fun DataPersonMovieCastAndCrew.toLocalPersonMovieCastAndCrewRelation(personId : String) =
    PersonMovieCastAndCrewRelation(getId(personId,id.toString()), personMovieCastAndCrewId=id.toString(),personId=personId)



fun List<DataPersonMovieCastAndCrew>.toLocalPersonMovieCastAndCrewRelationList(personId : String) : List<PersonMovieCastAndCrewRelation>{
    val list = mutableListOf<PersonMovieCastAndCrewRelation>()
    this.forEach { list.add(it.toLocalPersonMovieCastAndCrewRelation(personId)) }
    return list
}