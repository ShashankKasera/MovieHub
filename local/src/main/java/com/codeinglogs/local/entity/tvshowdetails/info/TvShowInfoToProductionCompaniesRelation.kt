package com.codeinglogs.local.entity.tvshowdetails.info

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.util.getId
import com.codeinglogs.data.model.tvshow.tvshowdetails.info.TvShowProductionCompany as DataTvShowProductionCompany

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = TvShowProductionCompany::class,
            parentColumns = ["id"],
            childColumns = ["tvShowProductionCompaniesId"],
            onDelete = ForeignKey.CASCADE
        ),ForeignKey(
            entity = TvShowInfoResponse::class,
            parentColumns = ["id"],
            childColumns = ["tvShowId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)

data class TvShowInfoToProductionCompaniesRelation(
    @PrimaryKey(autoGenerate = false)
    val id :String,
    val tvShowProductionCompaniesId : String,
    val tvShowId : String
)

fun DataTvShowProductionCompany.toLocalTvShowInfoToProductionCompaniesRelation(tvShowId : String) = TvShowInfoToProductionCompaniesRelation(
    getId(tvShowId,id.toString()), tvShowProductionCompaniesId = id.toString(),tvShowId=tvShowId)

fun List<DataTvShowProductionCompany>.toLocalTvShowInfoToProductionCompaniesRelationList(tvShowId : String) : List<TvShowInfoToProductionCompaniesRelation>{
    val list = mutableListOf<TvShowInfoToProductionCompaniesRelation>()
    this.forEach { list.add(it.toLocalTvShowInfoToProductionCompaniesRelation(tvShowId)) }
    return list
}