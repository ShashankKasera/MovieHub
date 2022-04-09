package com.codeinglogs.local.entity.tvshowdetails.info
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.util.getId
import com.codeinglogs.data.model.tvshow.tvshowdetails.info.TvShowGenre as DatTvShowGenre

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = TvShowGenre::class,
            parentColumns = ["id"],
            childColumns = ["tvShowGenerId"],
            onDelete = ForeignKey.CASCADE
        ), ForeignKey(
            entity = TvShowInfoResponse::class,
            parentColumns = ["id"],
            childColumns = ["tvShowId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class TvShowInfoToGenerRelation(
    @PrimaryKey(autoGenerate = false)
    val id : String,
    val tvShowGenerId : String,
    val tvShowId : String,
)

fun DatTvShowGenre.toLocalTvShowInfoToGenerRelation(tvShowId:String) = TvShowInfoToGenerRelation(getId(tvShowId,id.toString()), tvShowGenerId = id.toString(),tvShowId=tvShowId)

fun List<DatTvShowGenre>.toLocalTvShowInfoToGenerRelationList(tvShowId:String) : List<TvShowInfoToGenerRelation>{
    val list = mutableListOf<TvShowInfoToGenerRelation>()
    this.forEach { list.add(it.toLocalTvShowInfoToGenerRelation(tvShowId)) }
    return list
}