package com.codeinglogs.local.entity.moviedetail.image

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.local.entity.moviedetail.info.MovieInfoResponse
import com.codeinglogs.util.getId
import com.codeinglogs.data.model.movies.moviedetail.images.MovieBackdrop as DataMovieBackdrop

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = MovieBackdrop::class,
            parentColumns = ["file_path"],
            childColumns = ["movieBackdropFilePath"],
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
data class MovieImagesToBackdropRelation(
    @PrimaryKey(autoGenerate = false)
    val id : String,
    val movieBackdropFilePath : String,
    val movieId : String
)

fun DataMovieBackdrop.toLocalMovieImagesToBackdropRelation(movieId : String) = MovieImagesToBackdropRelation(
    getId(movieId,file_path), movieBackdropFilePath=file_path,movieId=movieId)

fun List<DataMovieBackdrop>.toLocalMovieImagesToBackdropRelationList(movieId : String) : List<MovieImagesToBackdropRelation>{
    val list = mutableListOf<MovieImagesToBackdropRelation>()
    this.forEach { list.add(it.toLocalMovieImagesToBackdropRelation(movieId)) }
    return list
}