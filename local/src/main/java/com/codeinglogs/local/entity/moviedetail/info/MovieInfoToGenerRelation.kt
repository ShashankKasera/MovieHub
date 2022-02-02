package com.codeinglogs.local.entity.moviedetail.info

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.util.getId
import com.codeinglogs.data.model.movies.moviedetail.info.MovieGener as DataMovieGener

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = MovieGener::class,
            parentColumns = ["id"],
            childColumns = ["movieGenerId"],
            onDelete = ForeignKey.CASCADE
        ),ForeignKey(
            entity = MovieInfoResponse::class,
            parentColumns = ["id"],
            childColumns = ["movieId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class MovieInfoToGenerRelation(
    @PrimaryKey(autoGenerate = false)
    val id : String,
    val movieGenerId : String,
    val movieId : String,
)

fun DataMovieGener.toLocalMovieInfoToGenerRelation(movieId:String) = MovieInfoToGenerRelation(getId(movieId,id.toString()), movieGenerId = id.toString(),movieId=movieId)

fun List<DataMovieGener>.toLocalMovieInfoToGenerRelationList(movieId:String) : List<MovieInfoToGenerRelation>{
    val list = mutableListOf<MovieInfoToGenerRelation>()
    this.forEach { list.add(it.toLocalMovieInfoToGenerRelation(movieId)) }
    return list
}