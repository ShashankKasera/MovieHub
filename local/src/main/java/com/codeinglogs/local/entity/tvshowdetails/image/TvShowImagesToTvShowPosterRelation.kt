package com.codeinglogs.local.entity.tvshowdetails.image
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.local.entity.tvshowdetails.info.TvShowInfoResponse
import com.codeinglogs.util.getId
import com.codeinglogs.data.model.tvshow.tvshowdetails.image.TvShowPoster as DataTvShowPoster

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = TvShowPoster::class,
            parentColumns = ["file_path"],
            childColumns = ["tvShowPosterFilePath"],
            onDelete = ForeignKey.CASCADE
        ),ForeignKey(
            entity = TvShowInfoResponse::class,
            parentColumns = ["id"],
            childColumns = ["tvShowId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)

data class TvShowImagesToTvShowPosterRelation(
    @PrimaryKey(autoGenerate = false)
    val id : String,
    val tvShowPosterFilePath : String,
    val tvShowId : String
)


fun DataTvShowPoster.toLocalTvShowImagesToMoviePosterRelation(tvShowId : String) = TvShowImagesToTvShowPosterRelation(
    getId(tvShowId,file_path), tvShowPosterFilePath=file_path,tvShowId=tvShowId)

fun List<DataTvShowPoster>.toLocalTvShowImagesToMoviePosterRelationList(tvShowId : String) : List<TvShowImagesToTvShowPosterRelation>{
    val list = mutableListOf<TvShowImagesToTvShowPosterRelation>()
    this.forEach { list.add(it.toLocalTvShowImagesToMoviePosterRelation(tvShowId)) }
    return list
}

