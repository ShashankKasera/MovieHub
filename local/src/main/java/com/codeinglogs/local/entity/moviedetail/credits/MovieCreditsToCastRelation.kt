package com.codeinglogs.local.entity.moviedetail.credits

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.codeinglogs.local.entity.Persons
import com.codeinglogs.local.entity.moviedetail.info.MovieInfoResponse
import com.codeinglogs.util.getId
import com.codeinglogs.data.model.person.personlist.Person as DataMovieCast

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = Persons::class,
            parentColumns = ["id"],
            childColumns = ["movieCastId"],
            onDelete = ForeignKey.CASCADE
        ),ForeignKey(
            entity = MovieInfoResponse::class,
            parentColumns = ["id"],
            childColumns = ["movieId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class MovieCreditsToCastRelation (
    @PrimaryKey(autoGenerate = false)
    val id : String,// id_12123_31223
    val movieCastId : String, //12123
    val movieId : String, //31223
)

fun DataMovieCast.toLocalMovieCreditsToCastRelation(movieId : String,) = MovieCreditsToCastRelation(getId(movieId,id.toString()),movieCastId = id.toString(),movieId=movieId)

fun List<DataMovieCast>.toLocalMovieCreditsToCastRelationList(movieId : String,) : List<MovieCreditsToCastRelation>{
    val list = mutableListOf<MovieCreditsToCastRelation>()
    this.forEach { list.add(it.toLocalMovieCreditsToCastRelation(movieId)) }
    return list
}