package com.codeinglogs.local.entity.tvshowdetails.image
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.util.getId
import com.codeinglogs.local.entity.tvshowdetails.info.TvShowInfoResponse
import com.codeinglogs.data.model.tvshow.tvshowdetails.image.TvShowBackdrop as DataTvShowBackdrop

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = TvShowBackdrop::class,
            parentColumns = ["file_path"],
            childColumns = ["tvShowBackdropFilePath"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = TvShowInfoResponse::class,
            parentColumns = ["id"],
            childColumns = ["tvShowId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class TvShowImagesToBackdropRelation(
    @PrimaryKey(autoGenerate = false)
    val id : String,
    val tvShowBackdropFilePath : String,
    val tvShowId : String
)

fun DataTvShowBackdrop.toLocalTvShowImagesToBackdropRelation(tvShowId : String) =
    TvShowImagesToBackdropRelation(getId(tvShowId,file_path), tvShowBackdropFilePath=file_path,tvShowId=tvShowId)

fun List<DataTvShowBackdrop>.toLocalTvShowImagesToBackdropRelationList(tvShowId : String) : List<TvShowImagesToBackdropRelation>{
    val list = mutableListOf<TvShowImagesToBackdropRelation>()
    this.forEach { list.add(it.toLocalTvShowImagesToBackdropRelation(tvShowId)) }
    return list
}
