package com.codeinglogs.local.entity.tvshowdetails.credits

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.local.entity.Persons
import com.codeinglogs.local.entity.tvshowdetails.info.TvShowInfoResponse
import com.codeinglogs.util.getId
import com.codeinglogs.data.model.person.personlist.Person as DataTvShowCrew

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Persons::class,
            parentColumns = ["id"],
            childColumns = ["tvShowCrewId"],
            onDelete = ForeignKey.CASCADE
        ), ForeignKey(
            entity = TvShowInfoResponse::class,
            parentColumns = ["id"],
            childColumns = ["tvShowId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class TvShowCreditsToCrewRelation (
    @PrimaryKey(autoGenerate = false)
    val id : String,
    val tvShowCrewId : String,
    val tvShowId : String,
)

fun DataTvShowCrew.toLocalTvShowCreditsToCrewRelation(tvShowId : String,) = TvShowCreditsToCrewRelation(getId(tvShowId,id.toString()),tvShowCrewId = id.toString(),tvShowId=tvShowId)

fun List<DataTvShowCrew>.toLocalTvShowCreditsToCrewRelationList(tvShowId : String,) : List<TvShowCreditsToCrewRelation>{
    val list = mutableListOf<TvShowCreditsToCrewRelation>()
    this.forEach { list.add(it.toLocalTvShowCreditsToCrewRelation(tvShowId)) }
    return list
}
