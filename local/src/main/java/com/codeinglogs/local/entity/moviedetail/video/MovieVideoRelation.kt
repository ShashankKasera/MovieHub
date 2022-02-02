package com.codeinglogs.local.entity.moviedetail.video

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.local.entity.moviedetail.info.MovieInfoResponse
import com.codeinglogs.local.entity.moviedetail.reviews.MovieReviewRelation
import com.codeinglogs.util.getId

import com.codeinglogs.data.model.movies.moviedetail.videos.MovieVideo as DataMovieVideo

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = MovieVideo::class,
            parentColumns = ["id"],
            childColumns = ["movieVideoId"],
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
data class MovieVideoRelation(
    @PrimaryKey(autoGenerate = false)
    val id : String,
    val movieVideoId : String,
    val movieId : String
)

fun DataMovieVideo.toLocalMovieVideoRelation(movieId : String) = MovieVideoRelation(getId(movieId,id), movieVideoId = id,movieId=movieId)

fun List<DataMovieVideo>.toLocalMovieVideoRelationList(movieId : String) : List<MovieVideoRelation>{
    val list = mutableListOf<MovieVideoRelation>()
    this.forEach { list.add(it.toLocalMovieVideoRelation(movieId)) }
    return list
}