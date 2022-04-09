package com.codeinglogs.local.entity.tvshowdetails.reviews

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.codeinglogs.data.model.tvshow.tvshowdetails.reviews.TvShowReviews as DataTvShowReviews

@Entity
data class TvShowReviews(
    @PrimaryKey
    val id: String,
    val author: String,
    val content: String,
)

fun TvShowReviews.toDataTvShowReviews() =
    DataTvShowReviews(
        id = id,
        author = author,
        content = content,
    )

fun List<TvShowReviews>.toDataTvShowReviews() : List<DataTvShowReviews>{
    val list = mutableListOf<DataTvShowReviews>()
    this.forEach { list.add(it.toDataTvShowReviews()) }
    return list
}

fun DataTvShowReviews.toLocalTvShowReviews() = TvShowReviews(
    id=id,
    author =author,
    content =content,

)

fun List<DataTvShowReviews>.toLocalTvShowReviewsList() : List<TvShowReviews>{
    val list = mutableListOf<TvShowReviews>()
    this.forEach { list.add(it.toLocalTvShowReviews()) }
    return list
}
