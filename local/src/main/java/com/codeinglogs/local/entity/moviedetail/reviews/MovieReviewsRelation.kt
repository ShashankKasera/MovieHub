package com.codeinglogs.local.entity.moviedetail.reviews

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.local.entity.moviedetail.info.MovieInfoResponse
import com.codeinglogs.util.getId
import com.codeinglogs.data.model.movies.moviedetail.reviews.MovieReviews as DataMovieReviews

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = MovieReviews::class,
            parentColumns = ["id"],
            childColumns = ["movieReviewsId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = MovieInfoResponse::class,
            parentColumns = ["id"],
            childColumns = ["movieId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class MovieReviewRelation(
    @PrimaryKey(autoGenerate = false)
    val id : String,
    val movieReviewsId : String,
    val movieId : String
)

fun DataMovieReviews.toLocalMovieReviewsRelation(movieId : String) = MovieReviewRelation(getId(movieId,id), movieReviewsId = id,movieId=movieId)

fun List<DataMovieReviews>.toLocalMovieReviewsRelationList(movieId : String) : List<MovieReviewRelation>{
    val list = mutableListOf<MovieReviewRelation>()
    this.forEach { list.add(it.toLocalMovieReviewsRelation(movieId)) }
    return list
}