package com.codeinglogs.local.entity.tvshowdetails.info

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.util.getId

import com.codeinglogs.data.model.tvshow.tvshowdetails.info.TvShowSeason as DataTvShowSeason
@Entity(
    foreignKeys = [
        ForeignKey(
            entity = TvShowSeason::class,
            parentColumns = ["id"],
            childColumns = ["tvShowSeasonId"],
            onDelete = ForeignKey.CASCADE
        ), ForeignKey(
            entity = TvShowInfoResponse::class,
            parentColumns = ["id"],
            childColumns = ["tvShowId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class TvShowInfoToSeasonRelation (
    @PrimaryKey(autoGenerate = false)
    val id :String,
    val tvShowSeasonId : String,
    val tvShowId : String
)

fun DataTvShowSeason.toLocalTvShowInfoToSeasonRelation(tvShowId : String) = TvShowInfoToSeasonRelation(
    getId(tvShowId,id.toString()), tvShowSeasonId = id.toString(),tvShowId=tvShowId)

fun List<DataTvShowSeason>.toLocalTvShowInfoToSeasonRelationList(tvShowId : String) : List<TvShowInfoToSeasonRelation>{
    val list = mutableListOf<TvShowInfoToSeasonRelation>()
    this.forEach { list.add(it.toLocalTvShowInfoToSeasonRelation(tvShowId)) }
    return list
}