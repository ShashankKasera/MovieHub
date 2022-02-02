package com.codeinglogs.local.entity.moviedetail.credits

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.local.entity.Persons
import com.codeinglogs.local.entity.moviedetail.info.MovieInfoResponse
import com.codeinglogs.util.getId
import com.codeinglogs.data.model.person.personlist.Person as DataMovieCrew

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Persons::class,
            parentColumns = ["id"],
            childColumns = ["movieCrewId"],
            onDelete = ForeignKey.CASCADE
        ), ForeignKey(
            entity = MovieInfoResponse::class,
            parentColumns = ["id"],
            childColumns = ["movieId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class MovieCreditsToCrewRelation (
    @PrimaryKey(autoGenerate = false)
    val id : String,
    val movieCrewId : String,
    val movieId : String,
)

fun DataMovieCrew.toLocalMovieCreditsToCrewRelation(movieId : String,) = MovieCreditsToCrewRelation(getId(movieId,id.toString()),movieCrewId = id.toString(),movieId=movieId)

fun List<DataMovieCrew>.toLocalMovieCreditsToCrewRelationList(movieId : String,) : List<MovieCreditsToCrewRelation>{
    val list = mutableListOf<MovieCreditsToCrewRelation>()
    this.forEach { list.add(it.toLocalMovieCreditsToCrewRelation(movieId)) }
    return list
}