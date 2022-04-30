package com.codeinglogs.local.entity.person.tvcredits

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.local.entity.person.info.PersonInfoResponse
import com.codeinglogs.util.getId
import com.codeinglogs.data.model.person.persondetails.tvcredits.PersonTvCastAndCrew as DataPersonTvCastAndCrew

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = PersonTvCastAndCrew::class,
            parentColumns = ["id"],
            childColumns = ["personTvCastAndCrewId"],
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
data class PersonTvCastAndCrewRelation(
    @PrimaryKey(autoGenerate = false)
    val id : String,
    val personTvCastAndCrewId : String,
    val personId : String
)

fun DataPersonTvCastAndCrew.toLocalPersonTvCastAndCrewRelation(personId : String) =
    PersonTvCastAndCrewRelation(getId(personId,id.toString()), personTvCastAndCrewId=id.toString(),personId=personId)



fun List<DataPersonTvCastAndCrew>.toLocalPersonTvCastAndCrewRelationList(personId : String) : List<PersonTvCastAndCrewRelation>{
    val list = mutableListOf<PersonTvCastAndCrewRelation>()
    this.forEach { list.add(it.toLocalPersonTvCastAndCrewRelation(personId)) }
    return list
}