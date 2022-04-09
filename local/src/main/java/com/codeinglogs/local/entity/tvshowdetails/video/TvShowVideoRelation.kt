package com.codeinglogs.local.entity.tvshowdetails.video
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.local.entity.tvshowdetails.info.TvShowInfoResponse
import com.codeinglogs.util.getId
import com.codeinglogs.data.model.tvshow.tvshowdetails.video.TvShowsVideos as DataTvShowsVideos


@Entity(
    foreignKeys = [
        ForeignKey(
            entity = TvShowVideo::class,
            parentColumns = ["id"],
            childColumns = ["tvShowVideoId"],
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
data class TvShowVideoRelation(
    @PrimaryKey(autoGenerate = false)
    val id : String,
    val tvShowVideoId : String,
    val tvShowId : String
)

fun DataTvShowsVideos.toLocalTvShowVideoRelation(tvShowId : String) = TvShowVideoRelation(getId(tvShowId,id), tvShowVideoId = id,tvShowId=tvShowId)

fun List<DataTvShowsVideos>.toLocalTvShowVideoRelationList(tvShowId : String) : List<TvShowVideoRelation>{
    val list = mutableListOf<TvShowVideoRelation>()
    this.forEach { list.add(it.toLocalTvShowVideoRelation(tvShowId)) }
    return list
}
