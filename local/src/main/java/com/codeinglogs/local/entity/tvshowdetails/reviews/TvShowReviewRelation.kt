package com.codeinglogs.local.entity.tvshowdetails.reviews
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.local.entity.tvshowdetails.info.TvShowInfoResponse
import com.codeinglogs.util.getId
import com.codeinglogs.data.model.tvshow.tvshowdetails.reviews.TvShowReviews as DataTvShowReviews

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = TvShowReviews::class,
            parentColumns = ["id"],
            childColumns = ["tvShowReviewsId"],
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

data class TvShowReviewRelation(
    @PrimaryKey(autoGenerate = false)
    val id : String,
    val tvShowReviewsId : String,
    val tvShowId : String
)

fun DataTvShowReviews.toLocalTvShowReviewsRelation(tvShowId : String) = TvShowReviewRelation(getId(tvShowId,id), tvShowReviewsId = id,tvShowId=tvShowId)

fun List<DataTvShowReviews>.toLocalTvShowReviewsRelationList(tvShowId : String) : List<TvShowReviewRelation>{
    val list = mutableListOf<TvShowReviewRelation>()
    this.forEach { list.add(it.toLocalTvShowReviewsRelation(tvShowId)) }
    return list
}