package com.codeinglogs.local.entity.moviedetail.image

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.local.entity.moviedetail.info.MovieInfoResponse
import com.codeinglogs.util.getId
import com.codeinglogs.data.model.movies.moviedetail.images.MoviePoster as DataMovieMoviePoster

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = MoviePoster::class,
            parentColumns = ["file_path"],
            childColumns = ["moviePosterFilePath"],
            onDelete = ForeignKey.CASCADE
        ),ForeignKey(
            entity = MovieInfoResponse::class,
            parentColumns = ["id"],
            childColumns = ["movieId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class MovieImagesToMoviePosterRelation(
    @PrimaryKey(autoGenerate = false)
    val id : String,
    val moviePosterFilePath : String,
    val movieId : String
)


fun DataMovieMoviePoster.toLocalMovieImagesToMoviePosterRelation(movieId : String) = MovieImagesToMoviePosterRelation(
    getId(movieId,file_path), moviePosterFilePath=file_path,movieId=movieId)

fun List<DataMovieMoviePoster>.toLocalMovieImagesToMoviePosterRelationList(movieId : String) : List<MovieImagesToMoviePosterRelation>{
    val list = mutableListOf<MovieImagesToMoviePosterRelation>()
    this.forEach { list.add(it.toLocalMovieImagesToMoviePosterRelation(movieId)) }
    return list
}